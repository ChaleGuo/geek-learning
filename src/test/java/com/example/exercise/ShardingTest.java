package com.example.exercise;

import com.example.exercise.week7.shardingshpere.ShardingsphereApplication;
import com.example.exercise.week7.shardingshpere.data2.MyOrder;
import com.example.exercise.week7.shardingshpere.data2.OrderMapper;
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
    public void get(){
        MyOrder myOrder = orderMapper.selectByPrimaryKey(2L);
        System.out.println(myOrder);
    }


    @Test
    public void update(){
        MyOrder order = new MyOrder();
        order.setId(3L);
        order.setExpressCompany("顺丰");
        int i = orderMapper.updateByPrimaryKeySelective(order);
        System.out.println(i);
    }

}
