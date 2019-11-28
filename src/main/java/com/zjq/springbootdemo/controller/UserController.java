package com.zjq.springbootdemo.controller;

import com.zjq.springbootdemo.model.User;
import com.zjq.springbootdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

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
    @RequiresPermissions("admin")
    @RequiresRoles("admin")
    public List<User> getAll() {
        log.info("查询所有用户");
        return userService.getAll();
    }

    @GetMapping("/userinfo")
    public List<User> getAllUser() {
        return userService.getAll();
    }

    @GetMapping("/userinfo/{id}")
    public List<User> getUserById(@RequestBody User user) {
        log.info("用户："+user);
        return userService.getAll();
    }

    @PostMapping("/userinfo")
    public List<User> addUser() {
        return userService.getAll();
    }

    @PutMapping("/userinfo")
    public List<User> updateUser() {
        return userService.getAll();
    }


}
