package com.test;

import com.example.myrpcdemoclient.Order;
import com.example.myrpcdemoclient.OrderService;
import com.example.myrpcdemoconsumer.MyrpcClientApplication;
import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyrpcClientApplication.class)
public class DubboTest {

    @DubboReference
    private OrderService orderService;

    @Test
    public void  test1(){
        Order order = orderService.findOrderById(1);
        System.out.println(order);
    }
}
