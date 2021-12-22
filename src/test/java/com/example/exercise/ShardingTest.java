package com.example.exercise;

import com.example.exercise.week7.shardingshpere.ShardingsphereApplication;
import com.example.exercise.week7.shardingshpere.data2.MyOrder2;
import com.example.exercise.week7.shardingshpere.data2.OrderMapper2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ShardingsphereApplication.class)
public class ShardingTest {
    @Autowired
    private OrderMapper2 orderMapper;

    @Test
    public void get(){
        MyOrder2 myOrder = orderMapper.selectByPrimaryKey(2L);
        System.out.println(myOrder);
    }

    @Test
    public void insert(){
        MyOrder2 order2 = new MyOrder2();
        order2.setExpressCompany("京东");
        order2.setAddressId(123L);
        order2.setNum(123);
        order2.setAmount(456);
        order2.setPayType((byte) 1);
        order2.setProductId(123L);
        order2.setUserId(111L);
        int i = orderMapper.insertSelective(order2);
        System.out.println(i);
    }


    @Test
    public void update(){
        MyOrder2 order = new MyOrder2();
        order.setId(2L);
        order.setExpressCompany("顺丰");
        int i = orderMapper.updateByPrimaryKeySelective(order);
        System.out.println(i);
    }

}
