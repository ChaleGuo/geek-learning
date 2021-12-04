package com.example.exercise.week5.assembly;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author chale
 */
@Data
@Component
public class Klass {
    @Autowired
    private List<IStudent> students;

    public void showStudents(){
        System.out.println(this.getStudents());
    }
}
