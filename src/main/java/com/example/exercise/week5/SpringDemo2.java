package com.example.exercise.week5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class SpringDemo2 {
    /**
     * 使用注解方式装配
     * @param args
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AssemblyConfig.class);
        Student student333 = (Student) context.getBean("student333");
        System.out.println(student333);
        Map<String, IStudent> beans = context.getBeansOfType(IStudent.class);
        System.out.println(beans);

        Klass klass = (Klass) context.getBean("klass");
        System.out.println(klass);

        School school = (School) context.getBean("school");
        school.showSchool();
    }
}
