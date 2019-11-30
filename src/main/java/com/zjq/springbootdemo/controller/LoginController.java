package com.zjq.springbootdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 登陆
 * @author: BadGuy
 * @date: 2019-11-27 20:50
 **/
@RestController
@Slf4j
public class LoginController {

    @RequestMapping("/login")
    public void login(String account,String password) {
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(account,password));
            log.info("login success");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            log.info("failed");
        }
    }

}
