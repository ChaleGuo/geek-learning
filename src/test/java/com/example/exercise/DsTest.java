package com.example.exercise;

import com.example.exercise.week7.ds.DsConfigApplication;
import com.example.exercise.week7.ds.UserService;
import com.example.exercise.week7.ds.mybatis.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DsConfigApplication.class)
public class DsTest {
    @Autowired
    UserService userService;

    @Test
    public void get(){
        Order order = userService.getOrder(1);
        System.out.println(order);
    }
}
