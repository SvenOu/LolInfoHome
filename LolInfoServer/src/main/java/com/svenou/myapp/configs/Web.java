package com.svenou.myapp.configs;

import com.svenou.myapp.ServerProfileLoader;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.web.filter.OrderedCharacterEncodingFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 * like web.xml
 */
@Configuration
@ImportAutoConfiguration(value = {ServerProfileLoader.class})
@ImportResource(value = {
        "classpath:com/svenou/myapp/configs/database-context.xml",
        "classpath:com/svenou/myapp/main/spring-context-main.xml",
        "classpath:com/svenou/myapp/security/spring-context-security.xml",
        "classpath:com/svenou/myapp/international/spring-il8n-locale.xml"
})
@ComponentScan(basePackages = {
        "com.svenou.myapp.main.controller",
        "com.svenou.myapp.security.controller",
        "com.svenou.myapp.international.controller"
})
public class Web extends WebMvcConfigurerAdapter{

    @Bean(name = "Set Character Encoding")
    public CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter filter = new OrderedCharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceRequestEncoding(true);
        filter.setForceResponseEncoding(true);
        return filter;
    }

    @Bean
    public WebMvcConfigurerAdapter forwardToIndex() {

        return new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                //welcome page
                registry.addViewController("/").setViewName("redirect:/login.html");
                //error pages
//                registry.addViewController("/302").setViewName("forward:/login.html");
//                registry.addViewController("/304").setViewName("forward:/login.html");
//                registry.addViewController("/403").setViewName("forward:/login.html");
//                registry.addViewController("/404").setViewName("forward:/login.html");
//                registry.addViewController("/500").setViewName("forward:/login.html");
            }
        };
    }


    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("locale");
        return lci;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
}
