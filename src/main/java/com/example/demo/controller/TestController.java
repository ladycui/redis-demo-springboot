package com.example.demo.controller;

import com.example.demo.entity.CommonResponse;
import com.example.demo.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Cui Yanna on 2019/6/27
 */

@RestController
@Slf4j
public class TestController {

    @Autowired
    RedisService redisService;

    @GetMapping(path = "/set/{key}")
    public CommonResponse setKey(@PathVariable String key) {
        log.info("setKey request: {}", key);
        CommonResponse response = redisService.setKey(key);
        return response;

    }

}
