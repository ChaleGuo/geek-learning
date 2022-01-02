package com.example.myrpc.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.example.myrpc.api.RpcfxRequest;
import com.example.myrpc.api.RpcfxResponse;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import static com.example.myrpc.client.Rpcfx.RpcfxInvocationHandler.JSONTYPE;

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
        RpcfxResponse response = post(request, myRpcClient.url());

        return JSON.parse(response.getResult().toString());
    }

    @SneakyThrows
    private RpcfxResponse post(RpcfxRequest req, String url) {
        String reqJson = JSON.toJSONString(req);
        System.out.println("req json: " + reqJson);

        // 1.可以复用client
        // 2.尝试使用httpclient或者netty client
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(JSONTYPE, reqJson))
                .build();
        String respJson = client.newCall(request).execute().body().string();
        System.out.println("resp json: " + respJson);
        return JSON.parseObject(respJson, RpcfxResponse.class);
    }
}
