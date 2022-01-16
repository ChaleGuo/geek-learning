package com.example.exercise.week11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class RedisSeq {
    @Autowired
    private RedisTemplate redisTemplate;

    public static String subInventory;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("if (redis.call('exists', KEYS[1]) == 1) then");
        sb.append("    local stock = tonumber(redis.call('get', KEYS[1]));");
        sb.append("    local num = tonumber(ARGV[1]);");
        sb.append("    if (stock == -1) then");
        sb.append("        return -1;");
        sb.append("    end;");
        sb.append("    if (stock >= num) then");
        sb.append("        return redis.call('incrby', KEYS[1],  -num);");
        sb.append("    end;");
        sb.append("    return -2;");
        sb.append("end;");
        sb.append("return -3;");
        subInventory = sb.toString();
    }

    /**
     * 生成分布式id
     *
     * @param key
     * @return
     */
    public long generateId(String key) {
        return redisTemplate.opsForValue().increment(key);
    }

    /**
     * 扣减库存
     * -3:库存未初始化
     * -2:库存不足
     * -1:不限库存
     * 大于等于0:剩余库存（扣减之后剩余的库存）
     *
     * @param key
     * @return
     */
    public long subInventory(String key, Integer value) {
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript();
        redisScript.setScriptText(subInventory);
        redisScript.setResultType(Long.class);

        return (Long) redisTemplate.execute(redisScript, Collections.singletonList(key), value);
    }
}
