package com.zjq.springbootdemo.controller;

import com.zjq.springbootdemo.model.People;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: People控制器
 * @author: BadGuy
 * @date: 2019-11-25 22:03
 **/
@RestController     //相当于同时加上了Controller和ResponseBody
public class PeopleController {

    @Resource
    People people;

    @RequestMapping("/getbadguy")
    public String getBadGuy(){
        return people.toString();
    }

}
