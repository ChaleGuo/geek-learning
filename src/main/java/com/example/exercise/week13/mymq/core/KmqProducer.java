package com.example.exercise.week13.mymq.core;

import org.springframework.stereotype.Component;

@Component
public class KmqProducer {

    private ImqBroker broker;

    public KmqProducer(KmqBroker broker) {
        this.broker = broker;
    }

    public boolean send(String topic, KmqMessage message) {
        Imq kmq = this.broker.findKmq(topic);
        if (null == kmq) throw new RuntimeException("Topic[" + topic + "] doesn't exist.");
        return kmq.send(message);
    }
}
