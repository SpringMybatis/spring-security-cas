package com.ibs.zj.cas.uum.security.model;

import java.io.Serializable;
import java.util.List;

/**
 * 资源模型
 * 
 * @author 李兵
 * 
 * @param <b>字段类型:Long</b> id 资源在数据库中的编号
 * @param <b>字段类型:String</b> resourceName 资源名称
 * @param <b>字段类型:String</b> resourceUrl 资源路径
 * @param <b>字段类型:List</b> roles 资源能被访问的角色集合<b>RoleCode</b>
 * 
 */
public class Resource implements Serializable {

	private static final long serialVersionUID = 118874446736705516L;

	/**
	 * 资源URL
	 */
	private String resourceUrl;

	/**
	 * 资源名称
	 */
	private String resourceName;

	/**
	 * 对应url拥有的可访问的角色集合
	 */
	private List<? extends RoleCode> roles;

	public String getResourceUrl() {
		return resourceUrl;
	}

	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}

	public List<? extends RoleCode> getRoles() {
		return roles;
	}

	public void setRoles(List<? extends RoleCode> roles) {
		this.roles = roles;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

}
