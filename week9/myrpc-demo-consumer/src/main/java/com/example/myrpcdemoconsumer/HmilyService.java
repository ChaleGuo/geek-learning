package com.example.myrpcdemoconsumer;

import com.example.myrpcdemoclient.Order;
import com.example.myrpcdemoclient.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.dromara.hmily.annotation.HmilyTCC;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HmilyService {

    @DubboReference
    private OrderService orderService;

    @HmilyTCC(confirmMethod = "confirm", cancelMethod = "cancel")
    public boolean test() {
        log.info("执行本地事务");

        Order order = new Order(1, "订单1", 10);
        return orderService.doTry(order);
    }

    public void confirm() {
        log.info("本地事务确认");
    }

    public void cancel() {
        log.info("本地事务手动回滚");
    }
}
