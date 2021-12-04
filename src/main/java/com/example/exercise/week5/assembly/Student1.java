package com.example.exercise.week5.assembly;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author chale
 */
@Data
@Component(value = "student333")
@Primary//有冲突的时候优先装配这个
public class Student1 implements IStudent {
    // @Value https://www.jianshu.com/p/933669270a9f
    @Value(value = "333")
    private Integer id;
    @Value("chale333")
    private String name;

    public void init() {
        System.out.println(name + " init()");
    }


}
