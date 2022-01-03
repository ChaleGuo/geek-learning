package com.example.myrpcdemoprovider;


import com.example.myrpcdemoclient.Order;
import com.example.myrpcdemoclient.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.dromara.hmily.annotation.HmilyTCC;

@DubboService
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Override
    public Order findOrderById(int id) {
        return new Order(id, "Cuijing" + System.currentTimeMillis(), 9.9f);
    }


    /**
     * tcc事务测试
     *
     * @param order
     * @return
     */
    @HmilyTCC(cancelMethod = "doCancel", confirmMethod = "doConfirm")
    @Override
    public boolean doTry(Order order) {
        log.info("start tryDo order={}", order);
        if (order.getId() % 2 == 0) {
            return true;
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public boolean doConfirm() {
        log.info("execute confirm");
        return true;
    }

    @Override
    public boolean doCancel() {
        log.info("execute cancel");
        return true;
    }
}
