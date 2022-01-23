package com.example.exercise.week12.mq;

import lombok.SneakyThrows;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;

import javax.jms.*;
import java.util.concurrent.atomic.AtomicInteger;

import static javax.jms.Session.AUTO_ACKNOWLEDGE;

public class ActivemqDemo {
    private static final String topicName = "chale-topic";
    private static final String queueName = "chale-queue";
    private static final String mqUrl = "tcp://127.0.0.1:61616";

    @SneakyThrows
    public static void main(String[] args) {
        Destination topic = new ActiveMQTopic(topicName);
        Destination queue = new ActiveMQQueue(queueName);

        consumerMq(topic);
        sendMq(topic);

    }

    /**
     * mq消费端
     * @param destination
     */
    @SneakyThrows
    private static void consumerMq(Destination destination) {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(mqUrl);
        ActiveMQConnection connection = (ActiveMQConnection) factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, AUTO_ACKNOWLEDGE);

        MessageConsumer consumer = session.createConsumer(destination);
        final AtomicInteger count = new AtomicInteger(0);
        consumer.setMessageListener(message -> System.out.println(count.getAndIncrement() + "--> consumer：" + message));

        //topic模式，两个消费者消费同一topic消息
        MessageConsumer consumer2 = session.createConsumer(destination);
        final AtomicInteger count2 = new AtomicInteger(0);
        consumer2.setMessageListener(message -> System.out.println(count2.getAndIncrement() + "--> consumer2：" + message));

        System.out.println("注册MessageListener完成！");
    }

    /**
     * mq发送端
     * @param destination
     */
    @SneakyThrows
    private static void sendMq(Destination destination) {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(mqUrl);
        ActiveMQConnection connection = (ActiveMQConnection) factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, AUTO_ACKNOWLEDGE);

        MessageProducer producer = session.createProducer(destination);
        for (int i = 0; i < 5; i++) {
            TextMessage message = session.createTextMessage(i + "--> test msg");
            producer.send(message);
        }
        session.close();
        connection.close();
        System.out.println("发送mq消息完成！");
    }
}
