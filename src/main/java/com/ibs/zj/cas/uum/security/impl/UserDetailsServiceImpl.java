package com.ibs.zj.cas.uum.security.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ibs.zj.cas.uum.security.SecurityService;
import com.ibs.zj.cas.uum.security.model.Account;
import com.ibs.zj.cas.uum.security.model.RoleCode;

@SuppressWarnings("deprecation")
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	private SecurityService securityService;

	public SecurityService getSecurityService() {
		return securityService;
	}

	public void setSecurityService(SecurityService securityService) {
		this.securityService = securityService;
	}

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		// 取得用户
		Account account = securityService.getAccountByName(username);
		if (account == null) {
			throw new UsernameNotFoundException("Can not found any Account by given username:" + username);
		}
		// 取得用户角色
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		if (account.getRoles() != null && !account.getRoles().isEmpty()) {
			Iterator<? extends RoleCode> roleIterator = account.getRoles().iterator();
			while (roleIterator.hasNext()) {
				RoleCode role = roleIterator.next();
				GrantedAuthority grantedAuthority = new GrantedAuthorityImpl(role.getRoleCode().toUpperCase());
				authorities.add(grantedAuthority);
			}
		}
		return new User(username, account.getPassword(), true, true, true,true, authorities);
	}
}