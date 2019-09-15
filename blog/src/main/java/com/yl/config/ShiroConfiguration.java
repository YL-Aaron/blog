package com.yl.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * shiro配置类
 *
 * @author yi
 * @desciption
 * @date 2019/8/28
 */
@Configuration
public class ShiroConfiguration {

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(authRealm());
        return securityManager;
    }

    @Bean
    public AuthRealm authRealm(){
        return new AuthRealm();
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager manager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(manager);
        bean.setLoginUrl("/login");
        bean.setSuccessUrl("/index");
        LinkedHashMap<String, String> filter = new LinkedHashMap<>();
        filter.put("/index", "authc");
        filter.put("/loginUser", "anon");
        filter.put("/css/**", "anon");
        filter.put("/fonts/**", "anon");
        filter.put("/images/**", "anon");
        filter.put("/js/**", "anon");
        filter.put("/lib/**", "anon");
        filter.put("/**", "authc");
        bean.setFilterChainDefinitionMap(filter);
        return bean;
    }
}
