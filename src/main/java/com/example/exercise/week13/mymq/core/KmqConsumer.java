package com.example.exercise.week13.mymq.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KmqConsumer<T> {

    @Autowired
    private KmqBroker broker;

    private Kmq kmq;

    public KmqConsumer() {
    }

    public KmqConsumer(KmqBroker broker) {
        this.broker = broker;
    }

    public void subscribe(String topic) {
        this.kmq = this.broker.findKmq(topic);
        if (null == kmq) throw new RuntimeException("Topic[" + topic + "] doesn't exist.");
    }

    public KmqMessage<T> poll(long timeout) {
        return kmq.poll(timeout);
    }

    public KmqMessage<T> poll(String topic) {
        this.kmq = this.broker.findKmq(topic);
        return kmq.poll();
    }

}
