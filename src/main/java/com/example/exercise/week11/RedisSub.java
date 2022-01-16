package com.example.exercise.week11;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RedisSub extends MessageListenerAdapter {

    @Override
    public void onMessage(Message message, byte[] pattern) {
        log.info("sub监听到的消息：message={}, pattern={}", message, new String(pattern));
    }
}
