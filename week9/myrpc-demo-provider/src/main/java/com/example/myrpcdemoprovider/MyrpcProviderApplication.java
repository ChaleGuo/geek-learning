package com.example.myrpcdemoprovider;


import com.example.myrpc.api.RpcfxRequest;
import com.example.myrpc.api.RpcfxResolver;
import com.example.myrpc.api.RpcfxResponse;
import com.example.myrpc.server.RpcfxInvoker;
import com.example.myrpcdemoclient.OrderService;
import com.example.myrpcdemoclient.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class MyrpcProviderApplication {

    public static void main(String[] args) throws Exception {
        // 进一步的优化，是在spring加载完成后，从里面拿到特定注解的bean，自动注册到zk

        SpringApplication.run(MyrpcProviderApplication.class, args);
    }

    @Autowired
    RpcfxInvoker invoker;

    @PostMapping("/")
    public RpcfxResponse invoke(@RequestBody RpcfxRequest request) {
        return invoker.invoke(request);
    }

    @Bean
    public RpcfxResolver createResolver() {
        return new DemoResolver();
    }

    @Bean
    public RpcfxInvoker createInvoker(@Autowired RpcfxResolver resolver) {
        return new RpcfxInvoker(resolver);
    }

    // 能否去掉name
    //

    // annotation


//    @Bean(name = "com.example.myrpcdemoclient.UserService")
    @Bean
    public UserService createUserService() {
        return new UserServiceImpl();
    }

//    @Bean(name = "com.example.myrpcdemoclient.OrderService")
    @Bean
    public OrderService createOrderService() {
        return new OrderServiceImpl();
    }

}
