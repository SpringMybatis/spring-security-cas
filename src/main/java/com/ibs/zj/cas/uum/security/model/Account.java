package com.ibs.zj.cas.uum.security.model;

import java.io.Serializable;
import java.util.List;

/**
 * 登陆时使用的用户帐号验证模型
 * 
 * @author 李兵
 * 
 * @param <b>字段类型:Long</b> id 注册用户在数据库中的编号
 * @param <b>字段类型:String</b> userName 注册用户帐号
 * @param <b>字段类型:String</b> password 注册用户密码
 * @param <b>字段类型:Integer</b> activity 注册用户帐号状态(0-启用，1-禁用)
 * @param <b>字段类型:List</b> roles 注册用户拥有的角色集合<b>RoleCode</b>
 * 
 */

public class Account implements Serializable {

	private static final long serialVersionUID = -32631301859939525L;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 用户密码
	 */
	private String password;
	/**
	 * 用户状态
	 */
	private Integer activity;
	/**
	 * 用户所具有的角色集合
	 */
	private List<? extends RoleCode> roles;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getActivity() {
		return activity;
	}

	public void setActivity(Integer activity) {
		this.activity = activity;
	}

	public List<? extends RoleCode> getRoles() {
		return roles;
	}

	public void setRoles(List<? extends RoleCode> roles) {
		this.roles = roles;
	}

}
