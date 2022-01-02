package com.example.myrpc.client;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyRpcClient {

    public String classStr() default "";

    public String method();

    public String url() default "http://localhost:8088/";

}
