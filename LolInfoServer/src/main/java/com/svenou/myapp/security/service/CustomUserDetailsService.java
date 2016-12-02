package com.svenou.myapp.security.service;

import com.svenou.myapp.ServerProfileLoader;
import com.svenou.myapp.security.dao.CsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.HashSet;

public class CustomUserDetailsService implements UserDetailsService {


    @Autowired
    private CsDao csDao;

    @Override
    public UserDetails loadUserByUsername(String userId)
            throws UsernameNotFoundException {
        return this.findUserInfo(userId);
    }

    public User findUserInfo(String userId) {
        //for test use memory authentication
        if (ServerProfileLoader.currentServerMode.equalsIgnoreCase(ServerProfileLoader.MODE_TEST)) {
            return generalTestUser(userId);
        }else{
            String password = csDao.findPasswordByUserId(userId);
            boolean enabled = csDao.findEnabledByUserId(userId) > 0;
            Collection<GrantedAuthority> authorities = csDao.findAuthoritiesCollectionByUserId(userId);
        //      如果是加密过则decode
        //		Md5PasswordEncoder m =new Md5PasswordEncoder();
        //		System.out.println(m.decodePassword(password, userId));
            return new User(userId, password, enabled, true, true, true, authorities);
        }
    }

    private User generalTestUser(String userId) {
        Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>() {{
            add(new GrantedAuthority() {
                @Override
                public String getAuthority() {
                    return "ROLE_ADMIN";
                }
            });
            add(new GrantedAuthority() {
                @Override
                public String getAuthority() {
                    return "ROLE_USER";
                }
            });
        }};
        return new User(userId, "123456", true, true, true, true, authorities);
    }

}
