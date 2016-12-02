package com.svenou.myapp.security.service;

import javax.servlet.http.HttpServletRequest;

import com.svenou.myapp.security.bean.CSUser;

public interface CsService {

	public CSUser getCurrentUserDetails(HttpServletRequest request);
	
	public String getLoginSuccessUrl();
}
