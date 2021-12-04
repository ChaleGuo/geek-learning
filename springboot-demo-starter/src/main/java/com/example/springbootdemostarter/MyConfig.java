package com.example.springbootdemostarter;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class MyConfig {
    private String name = "java";
}
