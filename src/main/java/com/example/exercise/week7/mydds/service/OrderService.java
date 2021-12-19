package com.example.exercise.week7.mydds.service;

import com.example.exercise.week7.mydds.config.DsKey;
import com.example.exercise.week7.mydds.config.TargetDs;
import com.example.exercise.week7.data.Order;
import com.example.exercise.week7.data.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @TargetDs(DsKey.MASTER)
    public Order  getOrder(long id){
        Order order = orderMapper.selectByPrimaryKey(id);
        return order;
    }

}
