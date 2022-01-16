package com.example.exercise.week11;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * redis分布式锁
 */
@Component
public class RedisLock {
    @Autowired
    private RedisTemplate redisTemplate;

    @SneakyThrows
    public boolean lock(String key, String value, Long timeoutMillis) {
        for (int i = 0; i < 3; i++) {
            Boolean success = redisTemplate.opsForValue().setIfAbsent(key, value, timeoutMillis, TimeUnit.MILLISECONDS);
            if (Boolean.TRUE.equals(success)) {
                return true;
            }
            Thread.sleep(5);
        }
        return false;
    }

    public boolean unlock(String key, String value) {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript();
        redisScript.setScriptText(script);
        redisScript.setResultType(Long.class);
        Object result = redisTemplate.execute(redisScript, Collections.singletonList(key), value);

        System.out.println("unlock result:" + result);
        return "1".equals(result);
    }
}
