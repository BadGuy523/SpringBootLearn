package com.zjq.springbootdemo.service.impl;

import com.zjq.springbootdemo.mapper.UserMapper;
import com.zjq.springbootdemo.model.User;
import com.zjq.springbootdemo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 用户服务实现层
 * @author: BadGuy
 * @date: 2019-11-26 19:55
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }
}
