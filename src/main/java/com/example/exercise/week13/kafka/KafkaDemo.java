package com.example.exercise.week13.kafka;

import com.alibaba.fastjson.JSON;
import lombok.SneakyThrows;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.Future;

public class KafkaDemo {
    private static KafkaProducer producer;
    private static KafkaConsumer consumer;
    private static String topic="test-tp1";

    static {
        Properties prop1 = new Properties();
        prop1.put("bootstrap.servers", "localhost:9092");
        prop1.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        prop1.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer(prop1);

        Properties prop2 = new Properties();
        prop2.put("group.id", "java1-chale");
        prop2.put("bootstrap.servers", "localhost:9092");
        prop2.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        prop2.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        consumer = new KafkaConsumer(prop2);
    }

    public static void main(String[] args) {
        send("test msg:"+System.currentTimeMillis());
        consumer();
    }

    @SneakyThrows
    private static void send( String value) {
        ProducerRecord record = new ProducerRecord(topic, value);
        Future future = producer.send(record);
        Object o = future.get();
        System.out.println("=============>send result:" + JSON.toJSONString(o));
    }

    private static void consumer() {
        consumer.subscribe(Collections.singletonList(topic));
        while (true) { //拉取数据
            ConsumerRecords<String, String> poll = consumer.poll(Duration.ofSeconds(1));
            for (ConsumerRecord o : poll) {
                ConsumerRecord<String, String> record = (ConsumerRecord) o;

                System.out.println("=========>consumer value = " + JSON.toJSONString(record.value()));
            }
        }
    }
}
