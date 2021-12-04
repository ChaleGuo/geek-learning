package com.example.springbootdemostarter;

import lombok.Data;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
//扫描到对应的bean,才能在另一个项目中使用
@ComponentScan(value = "com.example.springbootdemostarter.domain")
public class MyConfig {
    private String name = "java";
}
