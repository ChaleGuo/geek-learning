package com.example.exercise.week7.dds.service;

import com.example.exercise.week7.dds.data.MyOrder;
import com.example.exercise.week7.dds.data.OrderMapper;
import com.example.exercise.week7.dds.config.DsKey;
import com.example.exercise.week7.dds.config.TargetDs;
import org.springframework.beans.factory.annotation.Autowired;

//@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @TargetDs(DsKey.MASTER)
    public MyOrder getOrder(long id){
        MyOrder myOrder = orderMapper.selectByPrimaryKey(id);
        return myOrder;
    }

}
