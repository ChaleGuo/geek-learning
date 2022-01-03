package com.example.myrpcdemoprovider;

import com.example.myrpc.api.RpcfxResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;

@Slf4j
public class DemoResolver implements RpcfxResolver, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object resolve(String serviceClass) {
        return this.applicationContext.getBean(serviceClass);
    }

    @Override
    public <T> T getBeanImpl(Class<T> type) {
        Map<String, T> beans = this.applicationContext.getBeansOfType(type);
//        log.info("beans of type: {}", beans.values());
        for (T value : beans.values()) {
            return value;
        }
        return null;
    }
}
