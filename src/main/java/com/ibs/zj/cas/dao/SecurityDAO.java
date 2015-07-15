package com.ibs.zj.cas.dao;

import java.util.List;

import com.ibs.zj.cas.model.Accounts;
import com.ibs.zj.cas.model.Resources;

public interface SecurityDAO {

	public Accounts getAccountByName(String userName);

	public List<Resources> getAllResources();

}
