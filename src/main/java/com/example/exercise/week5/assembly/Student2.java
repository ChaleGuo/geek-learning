package com.example.exercise.week5.assembly;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author chale
 */
@Data
@Component(value = "student444")
public class Student2 implements IStudent {
    @Value(value = "444")
    private Integer id;
    @Value("chale444")
    private String name;

    public void init() {
        System.out.println(name + " init()");
    }
}
