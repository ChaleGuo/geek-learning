package com.example.exercise.week13.mymq.client;

import com.example.exercise.week13.mymq.core.KmqConsumer;
import com.example.exercise.week13.mymq.core.KmqMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/mq/producer")
public class ConsumerController {
    private KmqConsumer kmqConsumer;

    @PostMapping("/poll")
    public KmqMessage poll(String topic) {
        KmqMessage message = kmqConsumer.poll(topic);
        return message;
    }
}
