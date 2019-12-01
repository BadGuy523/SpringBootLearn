package com.zjq.springbootdemo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 权限
 */
@Data
public class Permission implements Serializable {

    private String id;

    private String name;

    private String code;

}
