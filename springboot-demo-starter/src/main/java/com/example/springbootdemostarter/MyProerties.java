package com.example.springbootdemostarter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "my.demo")
public class MyProerties {
    private String name = "default";
}
