package com.ibs.zj.cas.uum.security;

import java.util.List;

import com.ibs.zj.cas.uum.security.model.Account;
import com.ibs.zj.cas.uum.security.model.Resource;

/**
 * Spring Secutiry 业务方法接口
 * 
 * 
 * @author 李兵
 * 
 */
public interface SecurityService {

	/**
	 * 按照帐号查找形影帐号的信息
	 * 
	 * @param userName
	 *            帐号
	 * 
	 * @return 相应信息
	 */
	<T extends Account> T getAccountByName(String userName);

	/**
	 * 查找所有url相关信息
	 * 
	 * @return url 相关角色访问信息
	 */
	List<? extends Resource> getAllResources();

}
