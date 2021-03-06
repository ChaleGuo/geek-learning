package com.example.springbootdemostarter;

import com.example.springbootdemostarter.domain.MySchool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootDemoStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoStarterApplication.class, args);
    }

    //用于starter项目测试
    @Autowired
    private MyInfo info;
    @Autowired
    private MySchool mySchool;
    @Bean
    public void printInfo(){
        System.out.println(info.getInfo());
        System.out.println(mySchool);
    }

}
