package com.example.exercise.week5;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo1 {
    /**
     * 使用xml进行bean装配
     */
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("week5/ApplicationBean.xml");
        Student student111 = (Student) context.getBean("student111");
        System.out.println(student111);

        Klass klass = (Klass) context.getBean("klass");
        System.out.println(klass);

        School school = (School) context.getBean("school");
        System.out.println(school);
    }
}
