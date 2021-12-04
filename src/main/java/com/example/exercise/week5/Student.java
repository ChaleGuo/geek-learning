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
@Primary//有冲突的时候优先装配这个
public class Student implements IStudent {
    @Value(value = "333")
    private Integer id;
    @Value("chale333")
    private String name;

    public void init() {
        System.out.println(name + " init()");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
