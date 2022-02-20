package com.example.exercise.week13.mymq.core;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 第二版本，自定义queue
 */
@Component
public final class MymqBroker implements ImqBroker<Mymq> { // Broker+Connection

    public static final int CAPACITY = 10000;

    private final Map<String, Mymq> mymqMap = new ConcurrentHashMap<>(64);

    public void createTopic(String name){
        mymqMap.putIfAbsent(name, new Mymq(name,CAPACITY));
    }

    public Mymq findKmq(String topic) {
        return this.mymqMap.get(topic);
    }

}
