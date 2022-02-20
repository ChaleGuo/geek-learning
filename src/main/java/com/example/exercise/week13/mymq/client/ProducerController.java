package com.example.exercise.week13.mymq.client;

import com.example.exercise.week13.mymq.core.KmqMessage;
import com.example.exercise.week13.mymq.core.KmqProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/mq/producer")
public class ProducerController {
    private KmqProducer kmqProducer;

    @PostMapping("/send")
    public boolean send(String topic, KmqMessage message) {
        boolean result = kmqProducer.send(topic, message);
        return result;
    }
}
