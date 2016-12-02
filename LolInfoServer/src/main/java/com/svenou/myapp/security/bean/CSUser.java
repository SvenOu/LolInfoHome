package com.svenou.myapp.security.bean;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CSUser extends User {

	private boolean hidePassword = true;
	private String languageCode;
	/*custom attribute*/
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CSUser(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);
	}

	@Override
	public String getPassword() {
		if(hidePassword) return null;
		return super.getPassword();
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public boolean isHidePassword() {
		return hidePassword;
	}

	public void setHidePassword(boolean hidePassword) {
		this.hidePassword = hidePassword;
	}	
}
