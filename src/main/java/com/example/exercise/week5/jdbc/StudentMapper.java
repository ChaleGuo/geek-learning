package com.example.exercise.week5.jdbc;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setAge(rs.getInt("age"));
        student.setId(rs.getInt("id"));
        student.setName(rs.getString("name"));
        return student;
    }
}
