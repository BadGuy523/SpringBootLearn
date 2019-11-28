package com.zjq.springbootdemo.mapper;

import com.zjq.springbootdemo.model.User;

import java.util.List;

/**
 * @description: 用户dao层
 * @author: BadGuy
 * @date: 2019-11-26 19:56
 **/
public interface UserMapper {

    public List<User> getAll();

    List<User> getUserById(String id);

    void addUser(User user);

    void updateUser(User user);
}
