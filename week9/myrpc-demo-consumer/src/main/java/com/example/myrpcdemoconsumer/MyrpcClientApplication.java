package com.example.myrpcdemoconsumer;


import com.example.myrpc.api.Filter;
import com.example.myrpc.api.LoadBalancer;
import com.example.myrpc.api.Router;
import com.example.myrpc.api.RpcfxRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.List;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(basePackages = "com.example")
public class MyrpcClientApplication {

    // 二方库
    // 三方库 lib
    // nexus, userserivce -> userdao -> user


    public static void main(String[] args) {
        SpringApplication.run(MyrpcClientApplication.class, args);

        //使用cglib动态代理
//        UserService userService = Rpcfx.cglibProxy(UserService.class, "http://localhost:8088/");

        //使用jdk动态代理
//        UserService userService = Rpcfx.create(UserService.class, "http://localhost:8088/");
//        User user = userService.findById(1);
//        System.out.println("find user id=1 from server: " + user.getName());
    }

/*
    @Autowired
    private UserService userService;
    @Bean
    public String test() {
//        使用aop，注解切面
        User user = userService.findById(1);
        System.out.println("aop user id=1 from server: " + user.getName());
        return "";
    }
*/

    private static class TagRouter implements Router {
        @Override
        public List<String> route(List<String> urls) {
            return urls;
        }
    }

    private static class RandomLoadBalancer implements LoadBalancer {
        @Override
        public String select(List<String> urls) {
            return urls.get(0);
        }
    }

    @Slf4j
    private static class CuicuiFilter implements Filter {
        @Override
        public boolean filter(RpcfxRequest request) {
            log.info("filter {} -> {}", this.getClass().getName(), request.toString());
            return true;
        }
    }
}



