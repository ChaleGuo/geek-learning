package com.example.springbootdemostarter.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author chale
 */
@Data
@Component
public class MyKlass {
    @Autowired
    private List<MyStudent> students;

    public void showStudents(){
        System.out.println(this.getStudents());
    }
}
