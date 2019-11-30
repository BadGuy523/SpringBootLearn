package com.zjq.springbootdemo.controller;

import com.zjq.springbootdemo.model.User;
import com.zjq.springbootdemo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @description: 用户控制器
 * @author: BadGuy
 * @date: 2019-11-26 19:52
 **/
@Controller
@RequestMapping("/user")
@Api(tags = "用户管理")
@Slf4j
public class UserController {

    @Resource
    UserService userService;

    @RequiresPermissions({"user:query"})
    @GetMapping("/checkoutUser")
    @ResponseBody
    public void checkoutUser() {
        //通过ajax访问无法通过统一异常拦截跳转至未授权界面
    }

    @RequiresPermissions({"user:delete"})
    @GetMapping("/deleteUser")
    //此处如果没有权限会在界面报错，需设置异常拦截，进行跳转至统一界面
    public String deleteUser() {
        return "delete";
    }

    @RequiresRoles({"admin"})
    @GetMapping("/toAdminHtml")
    public String toAdminHtml() {
        //通过控制器进行页面跳转
        return "admin";
    }
    @RequiresRoles(value = {"admin","user"},logical = Logical.OR)
    @GetMapping("/toUserHtml")
    public String toUserHtml() {
        return "user";
    }

    @GetMapping("/toTestHtml")
    public String toTestHtml() {
        return "test";
    }

    @RequestMapping("/getAll")
    @ResponseBody
    @RequiresPermissions("admin")
    @RequiresRoles("admin")
    public List<User> getAll() {
        log.info("查询所有用户");
        return userService.getAll();
    }

    @ApiOperation("查询所有用户")
    @ResponseBody
    @GetMapping("/userinfo")
    public List<User> getAllUser() {
        return userService.getAll();
    }

    @GetMapping("/userinfo/{id}")
    @ResponseBody
    @ApiOperation("根据id查询用户")
    @ApiImplicitParam(name = "id",value = "用户id",required = true)
    public List<User> getUserById(@PathVariable(value = "id") String id) {  //@PathVariable不能和@RequestBody一起用？
        log.info("---id:"+id);
        return userService.getUserById(id);
    }

    @PostMapping("/userinfo")
    @ResponseBody
    @ApiOperation("添加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name="name",value = "姓名"),
            @ApiImplicitParam(name="age",value = "年龄"),
            @ApiImplicitParam(name="account",value = "用户名"),
            @ApiImplicitParam(name="password",value = "密码")
    })
    public String addUser(User user) {
        user.setId(UUID.randomUUID().toString());
        userService.addUser(user);
        return "success";
    }

    @ApiOperation("修改用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value = "用户id"),
            @ApiImplicitParam(name="name",value = "姓名"),
            @ApiImplicitParam(name="age",value = "年龄"),
            @ApiImplicitParam(name="account",value = "用户名"),
            @ApiImplicitParam(name="password",value = "密码")
    })
    @PutMapping("/userinfo")
    @ResponseBody
    public String updateUser(User user) {
        userService.updateUser(user);
        return "success";
    }


}
