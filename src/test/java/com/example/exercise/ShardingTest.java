package com.example.exercise;

import com.example.exercise.week7.data.Order;
import com.example.exercise.week7.data.OrderMapper;
import com.example.exercise.week7.shardingshpere.ShardingsphereApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ShardingsphereApplication.class)
public class ShardingTest {
    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void test1(){
        Order order = orderMapper.selectByPrimaryKey(1L);
        System.out.println(order);
    }

}
