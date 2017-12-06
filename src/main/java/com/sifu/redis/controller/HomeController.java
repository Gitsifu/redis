package com.sifu.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author sifu
 * @version 1.0
 * @date 2017/12/5
 */
@RestController
public class HomeController {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/")
    public String test() throws InterruptedException {
        //添加缓存，过期时间为两秒
        redisTemplate.opsForValue().set("name","sifu",2, TimeUnit.SECONDS);
        //程序暂停五秒
        Thread.sleep(5000);
        //结果为null
        String name = redisTemplate.opsForValue().get("name");
        System.out.println(name);
        return name;
    }


}
