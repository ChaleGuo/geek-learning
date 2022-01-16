package com.example.exercise.week11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisSeq {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 生成分布式id
     * @param key
     * @return
     */
    public long generateId(String key){
        return redisTemplate.opsForValue().increment(key);
    }

    /**
     * 扣减库存
     * @param key
     * @return
     */
    public long deductInventory(String key){
        Long inventory = redisTemplate.opsForValue().decrement(key);

        return inventory;
    }
}
