package com.example.myrpc.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.example.myrpc.api.RpcfxRequest;
import com.example.myrpc.api.RpcfxResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class RpcClientAspect {
    static {
        ParserConfig.getGlobalInstance().addAccept("com.example");
    }

    @Around("@annotation(com.example.myrpc.client.MyRpcClient) && @annotation(myRpcClient)")
    public Object rpcClient(ProceedingJoinPoint joinPoint, MyRpcClient myRpcClient){
        log.info("rpc aop 开始");
        RpcfxRequest request = new RpcfxRequest();
        request.setServiceClass(myRpcClient.classStr());
        request.setMethod(myRpcClient.method());
        request.setParams(joinPoint.getArgs());
        RpcfxResponse response = Rpcfx.post(request, myRpcClient.url());

        return JSON.parse(response.getResult().toString());
    }


}
