package com.ibs.zj.cas.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibs.zj.cas.dao.SecurityDAO;
import com.ibs.zj.cas.model.Accounts;
import com.ibs.zj.cas.model.Resources;

@Repository
public class SecurityDAOImpl implements SecurityDAO{

	private static final String NAMESPACE = "com.ibs.zj.cas.SecurityMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	public Accounts getAccountByName(String userName) {
		
		return this.sqlSession.selectOne(NAMESPACE+"getAccountByName", userName);
	}

	public List<Resources> getAllResources() {
		
		return this.sqlSession.selectList(NAMESPACE+"getAllResources", null);
		
	}

}
