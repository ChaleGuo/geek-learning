package com.example.myrpc.api;

public interface Filter {

    boolean filter(RpcfxRequest request);

    // Filter next();

}
