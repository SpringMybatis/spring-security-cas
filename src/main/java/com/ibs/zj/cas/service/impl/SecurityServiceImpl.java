package com.ibs.zj.cas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibs.zj.cas.dao.SecurityDAO;
import com.ibs.zj.cas.model.Accounts;
import com.ibs.zj.cas.model.Resources;
import com.ibs.zj.cas.uum.security.SecurityService;

@Service
public class SecurityServiceImpl implements SecurityService{

	@Autowired
	private SecurityDAO securityDAO;
	
	@SuppressWarnings("unchecked")
	public Accounts getAccountByName(String userName) {
		return securityDAO.getAccountByName(userName);
	}

	public List<Resources> getAllResources() {
		return securityDAO.getAllResources();
	}

}
