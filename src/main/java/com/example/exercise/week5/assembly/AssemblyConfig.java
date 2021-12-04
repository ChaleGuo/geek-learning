package com.example.exercise.week5.assembly;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author chale
 */
@ComponentScan
@Configuration
public class AssemblyConfig {

    @Bean("student555")
    public IStudent getStudent(){
        Student student = new Student();
        //set的属性不会生效，@value注解会再次赋值
        // @see org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.AutowiredFieldElement.inject
        student.setId(555);
        student.setName("chale555");
        return student;
    }
}
