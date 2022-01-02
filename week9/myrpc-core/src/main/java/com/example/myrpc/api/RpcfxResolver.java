package com.example.myrpc.api;

public interface RpcfxResolver {

    Object resolve(String serviceClass);

    public <T> T getBeanImpl(Class<T>  type);
}
