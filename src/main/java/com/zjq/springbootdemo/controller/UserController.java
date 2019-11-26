package com.zjq.springbootdemo.controller;

import com.zjq.springbootdemo.model.User;
import com.zjq.springbootdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 用户控制器
 * @author: BadGuy
 * @date: 2019-11-26 19:52
 **/
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {


    @Resource
    UserService userService;

    @RequestMapping("/getAll")
    public List<User> getAll() {
        log.info("查询所有用户");
        return userService.getAll();
    }

}
