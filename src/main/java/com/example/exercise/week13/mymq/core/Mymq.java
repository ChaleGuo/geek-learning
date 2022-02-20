package com.example.exercise.week13.mymq.core;

import lombok.Data;

import java.util.Arrays;

@Data
public class Mymq implements Imq {

    private String topic;

    private KmqMessage[] queue;

    private int sendOffset;
    private int consumerOffset;

    public Mymq(String topic) {
        init(topic, 16);
    }

    public Mymq(String topic, int capacity) {
        init(topic, capacity);
    }

    private void init(String topic, int capacity) {
        this.topic = topic;
        this.queue = new KmqMessage[capacity];
    }

    public boolean send(KmqMessage message) {
        if (sendOffset >= queue.length) {
            //翻倍扩容
            queue = Arrays.copyOf(queue, 2 * queue.length);
        }

        queue[sendOffset++] = message;
        return true;
    }

    public KmqMessage poll() {
        return queue[consumerOffset++];
    }

}
