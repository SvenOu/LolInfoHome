package com.svenou.myapp.security.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public interface CsDao {
	public String findPasswordByUserId(String userId);
	public List<String> findAuthoritiesByUserId(String userId);
	public Collection<GrantedAuthority> findAuthoritiesCollectionByUserId(String userId);
	public int findEnabledByUserId(String userId);
}
