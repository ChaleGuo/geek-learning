package com.example.springbootdemostarter.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chale
 */
@Data
@Component
public class MySchool {
    @Autowired
    private MyKlass class1;
    @Autowired
    private MyStudent student;

    public void showSchool() {
        System.out.println("Class1 have " + this.class1.getStudents().size() + " students and one is " + this.student);
    }
}
