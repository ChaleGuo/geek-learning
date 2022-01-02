package com.example.myrpcdemoprovider;


import com.example.myrpcdemoclient.Order;
import com.example.myrpcdemoclient.OrderService;

public class OrderServiceImpl implements OrderService {

    @Override
    public Order findOrderById(int id) {
        return new Order(id, "Cuijing" + System.currentTimeMillis(), 9.9f);
    }
}
