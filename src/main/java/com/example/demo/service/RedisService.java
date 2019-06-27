package com.example.demo.service;

import com.example.demo.entity.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author Cui Yanna on 2019/6/27
 */
@Service
@Slf4j
public class RedisService {

    @Value("${redis.expire.time}")
    int expireTime;//unit second

    @Autowired
    RedisTemplate<String, Integer> redisTemplate;

    public CommonResponse setKey(String key) {
        int value = 0;
        ValueOperations<String, Integer> operations = redisTemplate.opsForValue();
        if (redisTemplate.hasKey(key)) {
            value = operations.get(key);
            log.info("get value from redis: {}", value);
            operations.set(key, ++value, expireTime, TimeUnit.SECONDS);
        } else {
            operations.set(key, value, expireTime, TimeUnit.SECONDS);
        }
        CommonResponse response = new CommonResponse(0, value + "");
        return response;
    }

}
