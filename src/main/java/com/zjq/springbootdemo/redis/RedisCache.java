package com.zjq.springbootdemo.redis;

import com.zjq.springbootdemo.model.User;
import com.zjq.springbootdemo.utils.ApplicationContextHolder;
import com.zjq.springbootdemo.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * Redis作为Mybatis的二级缓存
 */
@Slf4j
public class RedisCache implements Cache {

    private final String id;

    private RedisTemplate redisTemplate;

    private RedisUtil redisUtil;

    private RedisUtil getRedisUtil() {
        if (redisUtil == null) {
            redisUtil = ApplicationContextHolder.getBean("redisUtil");
        }
        return redisUtil;
    }

    private RedisTemplate getRedisTemplate() {
        if (redisTemplate == null) {
            redisTemplate = ApplicationContextHolder.getBean("redisTemplate");
        }
        return redisTemplate;
    }

    public RedisCache(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void putObject(Object o, Object o1) {
        RedisUtil redisUtil = getRedisUtil();
        redisUtil.lSet("userList", (List<User>) o1);
        log.info("将缓存存入redis");
    }

    @Override
    public Object getObject(Object o) {
        log.info("从redis中取得缓存");
        //RedisTemplate redisTemplate = getRedisTemplate();
        //List<Object> userList = redisTemplate.opsForList().range("userList", 0, -1);
        RedisUtil redisUtil = getRedisUtil();
        List<Object> userList = redisUtil.lGet("userList", 0, -1);
        return userList.size() == 0 ? null : userList;
    }

    @Override
    public Object removeObject(Object o) {
        log.info("从缓存中删除对应值");
        return null;
    }

    @Override
    public void clear() {
        log.info("发生更新时，清除缓存");
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return null;
    }
}
