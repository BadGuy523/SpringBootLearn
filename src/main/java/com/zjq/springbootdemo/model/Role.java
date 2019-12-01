package com.zjq.springbootdemo.model;

import lombok.Data;

import javax.naming.Name;
import java.io.Serializable;
import java.util.List;

/**
 * 角色
 */
@Data
public class Role implements Serializable {

    private String id;

    private String name;

    private String code;

    private List<Permission> permissions;

}
