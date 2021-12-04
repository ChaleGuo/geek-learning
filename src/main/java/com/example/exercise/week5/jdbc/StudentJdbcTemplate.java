package com.example.exercise.week5.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class StudentJdbcTemplate implements StudentDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Override
    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public void insert(String name, Integer age) {
        String sql = "insert into student (name,age) values (?,?)";
        int insert = jdbcTemplate.update(sql, name, age);
        System.out.println("insert rows=" + insert);
    }

    @Override
    public Student getStudent(Integer id) {
        String sql = "select * from student where id=?";
        Student student = jdbcTemplate.queryForObject(sql, new StudentMapper(), id);
        return student;
    }

    @Override
    public List<Student> listStudents() {
        String sql = "select * from student";
        List<Student> students = jdbcTemplate.query(sql, new StudentMapper());
        return students;
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from student where id=?";
        int delete = jdbcTemplate.update(sql, id);
        System.out.println("delete rows=" + delete);
    }

    @Override
    public void update(Integer id, Integer age) {
        String sql = "update student set age=? where id=?";
        int update = jdbcTemplate.update(sql, age, id);
        System.out.println("update rows=" + update);
    }
}
