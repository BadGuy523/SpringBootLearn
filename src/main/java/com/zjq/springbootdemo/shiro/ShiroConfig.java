package com.zjq.springbootdemo.shiro;

import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: shiro配置文件
 * @author: BadGuy
 * @date: 2019-11-27 20:23
 **/
@Configuration
public class ShiroConfig {

    @Bean
    MyRealm myRealm() {
        return new MyRealm();
    }

    @Bean
    DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(myRealm());
        return manager;
    }

    @Bean
    ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition definition = new DefaultShiroFilterChainDefinition();
        definition.addPathDefinition("/login","anon");
        definition.addPathDefinition("/login.html","anon");
        definition.addPathDefinition("/swagger-ui.html","anon");
        definition.addPathDefinition("/user/getAll","perms[admin]");
        definition.addPathDefinition("/hello.html","roles[admin]");
        return definition;
    }

}
