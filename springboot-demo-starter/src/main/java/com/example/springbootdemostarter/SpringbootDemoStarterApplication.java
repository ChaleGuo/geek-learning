package com.example.springbootdemostarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootDemoStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoStarterApplication.class, args);
    }

    @Autowired
    private MyInfo info;

    @Bean
    public void printInfo(){
        System.out.println(info.getInfo());
    }

}
