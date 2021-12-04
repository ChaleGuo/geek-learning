package com.example.exercise.week5;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author chale
 */
@Data
@Component(value = "student333")
@Primary
public class Student implements IStudent {
    @Value(value = "333")
    private Integer id;
    @Value("chale333")
    private String name;

    public void init() {
        System.out.println(name + " init()");
    }
}
