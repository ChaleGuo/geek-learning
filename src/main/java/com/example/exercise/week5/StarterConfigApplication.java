package com.example.exercise.week5;

import com.example.springbootdemostarter.MyInfo;
import com.example.springbootdemostarter.domain.MySchool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StarterConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarterConfigApplication.class, args);
    }

    @Autowired
    private MyInfo info;
    @Autowired
    private MySchool school;
    @Bean
    public void printInfo(){
        System.out.println("另一个项目："+info.getInfo());
        System.out.println("另一个项目："+school);
    }

}
