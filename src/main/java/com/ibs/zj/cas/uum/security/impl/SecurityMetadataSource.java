package com.ibs.zj.cas.uum.security.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import com.ibs.zj.cas.uum.security.SecurityService;
import com.ibs.zj.cas.uum.security.UrlMatcher;
import com.ibs.zj.cas.uum.security.model.Resource;
import com.ibs.zj.cas.uum.security.model.RoleCode;

public class SecurityMetadataSource implements
		FilterInvocationSecurityMetadataSource {
	private Logger log = Logger.getLogger(SecurityMetadataSource.class);
	private SecurityService securityService;
	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;
	private UrlMatcher urlMatcher;
	public SecurityMetadataSource(SecurityService securityService) {
		urlMatcher = new AntUrlPathMatcher();
		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
		// 可在构造方法中调用初始化方法，也可在配置文件中指定初始化方法
		this.securityService = securityService;
		loadResourceDefine();
	}

	/**
	 * method name : loadResourceDefine description : 初始化方法，得到所有资源以及每个资源对应的角色
	 * 
	 * @author : Ling.Xiang
	 * @param :
	 * @return : void Create at : Oct 13, 2012 4:38:26 PM modified :
	 */
	private void loadResourceDefine() {
		List<? extends Resource> resources = securityService.getAllResources();
		if(resources != null && !resources.isEmpty()){
			for(Resource resource : resources){
				Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
				Iterator<? extends RoleCode> roleIterator = resource.getRoles().iterator();
				while(roleIterator.hasNext()){
					RoleCode role = roleIterator.next();
					ConfigAttribute configAttribute = new SecurityConfig(role.getRoleCode());
					configAttributes.add(configAttribute);
				}
				resourceMap.put(resource.getResourceUrl(), configAttributes);
			}
		}
	}

	/**
	 * method name : getAttributes description :
	 * 将请求url和资源库比较，符合则将资源库的角色定义赋值给当前请求url
	 * 
	 * @author : Jiang.Hu modified : leo , May 27, 2011
	 * @see : @see org.springframework.security.access.SecurityMetadataSource#
	 *      getAttributes(java.lang.Object)
	 */
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		if ((object == null) || !this.supports(object.getClass())) {
			// logger.info("Object must be a FilterInvocation");
			throw new IllegalArgumentException(
					"Object must be a FilterInvocation");
		}
		Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
		if (object instanceof FilterInvocation) {
			String requestUrl = ((FilterInvocation) object).getRequestUrl();
			if (!StringUtils.isBlank(requestUrl)
					&& requestUrl.indexOf("?") != -1) {
				requestUrl = requestUrl.substring(0, requestUrl.indexOf("?"));
			}
			log.debug("请求url:" + requestUrl);
			// 比较请求url和资源库url，匹配则赋予对应的角色权限
			if (resourceMap != null && !resourceMap.isEmpty()) {
				Iterator<String> iterator = resourceMap.keySet().iterator();
				while (iterator.hasNext()) {
					String resourceUrl = iterator.next();
					if (urlMatcher.pathMatchesUrl(resourceUrl, requestUrl)) {
						configAttributes.addAll(resourceMap.get(resourceUrl));
					}
				}
				if (configAttributes.isEmpty()) {
					configAttributes.add(new SecurityConfig("nobody"));
				}
				for (ConfigAttribute configAttribute : configAttributes) {
					log.debug("请求url匹配角色：" + configAttribute.toString());
				}
				return configAttributes;
			}
		}
		return null;
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return new ArrayList<ConfigAttribute>();
	}

	public boolean supports(Class<?> clazz) {
		return FilterInvocation.class.isAssignableFrom(clazz);
	}

	public SecurityService getSecurityService() {
		return securityService;
	}

	public void setSecurityService(SecurityService securityService) {
		this.securityService = securityService;
	}

}
