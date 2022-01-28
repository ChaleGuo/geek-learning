package com.example.exercise.week13.mymq.core;

/**
 * broker抽象接口，可以有多个实现
 * KmqBroker 是原有的LinkedBlockingQueue实现
 * MymqBroker 是新增的数组实现
 * @param <R>
 */
public interface ImqBroker<R extends Imq> {
    void createTopic(String name);

    R findKmq(String topic);

}
