package com.example.exercise.week7.shardingshpere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan({"com.example.exercise.week7.shardingshpere.data2"})
//@ImportResource("classpath:sharding.properties")
public class ShardingsphereApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingsphereApplication.class, args);
    }

}
