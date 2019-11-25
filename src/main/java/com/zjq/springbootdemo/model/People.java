package com.zjq.springbootdemo.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @description: 人
 * @author: BadGuy
 * @date: 2019-11-25 21:55
 **/
@ConfigurationProperties(prefix = "badguy")
@Component
@Data
public class People {
    private String name;
}
