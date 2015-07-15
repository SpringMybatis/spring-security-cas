package com.ibs.zj.cas.model;

import com.ibs.zj.cas.uum.security.model.Account;

public class Accounts extends Account {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
