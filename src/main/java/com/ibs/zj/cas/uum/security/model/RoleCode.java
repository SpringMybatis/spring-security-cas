package com.ibs.zj.cas.uum.security.model;

import java.io.Serializable;

/**
 * 用户角色模型
 * 
 * 
 * @author 李兵
 * 
 * 
 * @param <b>字段类型:Long</b> id 角色在数据库中的编号
 * @param <b>字段类型:String</b> roleCode 角色Code
 * @param <b>字段类型:String</b> roleName 角色名字
 * 
 */
public class RoleCode implements Serializable {

	private static final long serialVersionUID = 6935806475319877702L;

	private String roleCode;

	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

}
