package com.example.exercise.week7.dds;

import com.example.exercise.week7.dds.config.DsKey;
import com.example.exercise.week7.dds.config.TargetDs;
import com.example.exercise.week7.dds.mybatis.Order;
import com.example.exercise.week7.dds.mybatis.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private OrderMapper orderMapper;

    @TargetDs(DsKey.MASTER)
    public Order  getOrder(long id){
        Order order = orderMapper.selectByPrimaryKey(id);
        return order;
    }

}
