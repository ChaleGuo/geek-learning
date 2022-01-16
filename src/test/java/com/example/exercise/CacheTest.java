package com.example.exercise;

import com.example.exercise.week11.CacheApplication;
import com.example.exercise.week11.RedisLock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CacheApplication.class)
public class CacheTest {
    @Autowired
    private RedisLock redisLock;
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test1() {
        Object testkey1 = redisTemplate.opsForValue().get("testkey1");
        System.out.println(testkey1);
    }

    @Test
    public void lockTest() {
        String lockKey = "testkey3";
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(uuid);
        boolean lock = redisLock.lock(lockKey, uuid, 5000L);
        System.out.println("lock:" + lock);

        boolean unlock = redisLock.unlock(lockKey, uuid);
        System.out.println("unlock:" + unlock);
    }


}
