package com.zjq.springbootdemo.controller;

import com.zjq.springbootdemo.utils.RedisUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * redis控制层
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Resource
    RedisUtil redisUtil;

    @GetMapping("/setString")
    public void setString() {
        redisUtil.lSet("name","admin");



    }

}
