package com.example.myrpc.server;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.myrpc.api.RpcException;
import com.example.myrpc.api.RpcfxRequest;
import com.example.myrpc.api.RpcfxResolver;
import com.example.myrpc.api.RpcfxResponse;

import java.lang.reflect.Method;
import java.util.Arrays;

public class RpcfxInvoker {

    private RpcfxResolver resolver;

    public RpcfxInvoker(RpcfxResolver resolver) {
        this.resolver = resolver;
    }


    public RpcfxResponse invoke(RpcfxRequest request) {
        RpcfxResponse response = new RpcfxResponse();
        try {
            // 作业1：改成泛型和反射
            Class<?> clazz = Class.forName(request.getServiceClass());
            Object service = resolver.getBeanImpl(clazz);

//            Object service = resolver.resolve(serviceClass);
            Method method = resolveMethodFromClass(clazz, request.getMethod());
            Object result = method.invoke(service, request.getParams()); // dubbo, fastjson,
            // 两次json序列化能否合并成一个
            response.setResult(JSON.toJSONString(result, SerializerFeature.WriteClassName));
            response.setStatus(true);
            return response;
        } catch (Exception e) {

            // 3.Xstream

            // 2.封装一个统一的RpcfxException
            // 客户端也需要判断异常
            e.printStackTrace();
            RpcException myException = new RpcException(1, e.getMessage());
            response.setException(myException);
            response.setStatus(false);
            return response;
        }
    }

    private Method resolveMethodFromClass(Class<?> klass, String methodName) {
        return Arrays.stream(klass.getMethods()).filter(m -> methodName.equals(m.getName())).findFirst().get();
    }

}
