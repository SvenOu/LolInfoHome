package com.svenou.myapp.configs;

import com.svenou.myapp.ServerProfileLoader;
import com.svenou.myapp.security.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class Security extends WebSecurityConfigurerAdapter {

    @Value("${jdbc.cs.successUrl}")
    private String successLoginUrl;

    @Bean
    CustomUserDetailsService customUserDetailsService(){
        return new CustomUserDetailsService();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/controller/locale/**"
        );
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .headers().frameOptions().disable()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(successLoginUrl).hasAnyRole("ADMIN", "USER")
                .antMatchers("/controller/**").hasAnyRole("ADMIN", "USER")
                .and()
                .anonymous()
                .disable()
                .sessionManagement()
                .sessionFixation()
                .none()
                .invalidSessionUrl("/login.html")
                .and()
                .formLogin()
                .loginPage("/login.html")
                .defaultSuccessUrl("/controller/security/loginEntry", true)
                .loginProcessingUrl("/j_spring_security_check")
                .usernameParameter("j_username")
                .passwordParameter("j_password")
                .failureForwardUrl("/login.html")
                .and()
                .logout()
                .logoutUrl("/j_spring_security_logout")
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/login.html");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(getApplicationContext().getBean(CustomUserDetailsService.class));
    }
}