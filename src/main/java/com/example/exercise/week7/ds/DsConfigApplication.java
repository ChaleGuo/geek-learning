package com.example.exercise.week7.ds;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.exercise.week7")
public class DsConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(DsConfigApplication.class, args);
    }

}
