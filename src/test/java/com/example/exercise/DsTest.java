package com.example.exercise;

import com.example.exercise.week7.mydds.DsConfigApplication;
import com.example.exercise.week7.mydds.service.OrderService;
import com.example.exercise.week7.data.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DsConfigApplication.class)
public class DsTest {
    @Autowired
    OrderService orderService;

    @Test
    public void get(){
        Order order = orderService.getOrder(1);
        System.out.println(order);
    }
}
