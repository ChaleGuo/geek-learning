package com.example.exercise.week5.assembly;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chale
 */
@Data
@Component
public class School {
    @Autowired
    private Klass class1;
    @Autowired
    private Student student;

    public void showSchool() {
        System.out.println("Class1 have " + this.class1.getStudents().size() + " students and one is " + this.student);
    }
}
