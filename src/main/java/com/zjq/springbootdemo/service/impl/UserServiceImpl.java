package com.zjq.springbootdemo.service.impl;

import com.zjq.springbootdemo.mapper.UserMapper;
import com.zjq.springbootdemo.model.User;
import com.zjq.springbootdemo.service.UserService;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 用户服务实现层
 * @author: BadGuy
 * @date: 2019-11-26 19:55
 **/
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public List<User> getAll() {
        List<User> users = userMapper.getAll();
        return userMapper.getAll();
    }

    @Override
    public List<User> getUserById(String id) {
        return userMapper.getUserById(id);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
}
