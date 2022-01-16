package com.example.exercise;

import com.example.exercise.week11.CacheApplication;
import com.example.exercise.week11.RedisLock;
import com.example.exercise.week11.RedisPub;
import com.example.exercise.week11.RedisSeq;
import lombok.SneakyThrows;
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
    private RedisSeq redisSeq;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisPub redisPub;

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


    @Test
    public void seqTest() {
        long id = redisSeq.generateId("order");
        System.out.println(id);

        long invent = redisSeq.deductInventory("order");
        System.out.println(invent);
    }


    @SneakyThrows
    @Test
    public void pubTest() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        redisPub.send(uuid);
        System.out.println("pub发送的消息：" + uuid);
        Thread.sleep(1000);
    }
}
