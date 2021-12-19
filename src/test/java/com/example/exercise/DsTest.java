package com.example.exercise;

import com.example.exercise.week7.dds.data.MyOrder;
import com.example.exercise.week7.dds.DsConfigApplication;
import com.example.exercise.week7.dds.service.OrderService;
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
        MyOrder myOrder = orderService.getOrder(1);
        System.out.println(myOrder);
    }
}
