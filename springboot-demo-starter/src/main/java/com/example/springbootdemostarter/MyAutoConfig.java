package com.example.springbootdemostarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(MyConfig.class)
@EnableConfigurationProperties(MyProerties.class)
public class MyAutoConfig {
    @Autowired
    private MyConfig myConfig;
    @Autowired
    private MyProerties myProerties;

    @Bean
    public MyInfo getInfo() {
        return new MyInfo(myConfig.getName() + ":" + myProerties.getName());
    }
}
