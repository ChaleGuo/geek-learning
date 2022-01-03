package com.example.myrpcdemoclient;

import org.dromara.hmily.annotation.Hmily;

public interface OrderService {

    Order findOrderById(int id);

    @Hmily
    boolean doTry(Order order);

    boolean doConfirm();

    boolean doCancel();
}
