package com.zjq.springbootdemo.service;

import com.zjq.springbootdemo.model.User;

import java.util.List;

/**
 * @description: 用户服务接口
 * @author: BadGuy
 * @date: 2019-11-26 19:55
 **/
public interface UserService {

    public List<User> getAll();

}
