package com.example.exercise.week13.mymq.core;

/**
 * mq抽象接口
 */
public interface Imq {
    boolean send(KmqMessage message);

    KmqMessage poll();

}
