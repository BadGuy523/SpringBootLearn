package com.zjq.springbootdemo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 用户实体类
 * @author: BadGuy
 * @date: 2019-11-26 19:50
 **/
@Data
public class User implements Serializable {

    private String id;

    private String name;

    private Integer age;

    private String account;

    private String password;

    private Role role;

}
