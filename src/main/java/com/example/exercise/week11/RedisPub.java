package com.example.exercise.week11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import static com.example.exercise.week11.RedisConfig.redisTopic;

@Component
public class RedisPub {
    @Autowired
    private RedisTemplate redisTemplate;

    public void send(String msg) {
        redisTemplate.convertAndSend(redisTopic, msg);
    }


}
