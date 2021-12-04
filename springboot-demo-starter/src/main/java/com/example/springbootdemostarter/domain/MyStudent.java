package com.example.springbootdemostarter.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author chale
 */
@Data
@Component()
@Primary//有冲突的时候优先装配这个
public class MyStudent {
    @Value(value = "333")
    private Integer id;
    @Value("chale333")
    private String name;
}
