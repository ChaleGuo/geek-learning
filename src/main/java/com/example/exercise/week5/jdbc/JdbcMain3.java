package com.example.exercise.week5.jdbc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * spring-jdbc操作
 */
public class JdbcMain3 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        StudentJdbcTemplate template = (StudentJdbcTemplate) context.getBean("studentJdbcTemplate");
        //增加
        template.insert("chale2",27);

        //查询
        Student student = template.getStudent(2);
        System.out.println(student);
        List<Student> students = template.listStudents();
        System.out.println(students);

        //更新
//        template.update(1,20);
//        student = template.getStudent(1);
//        System.out.println(student);

        //删除
//        template.delete(2);
//        students = template.listStudents();
//        System.out.println(students);

    }
}
