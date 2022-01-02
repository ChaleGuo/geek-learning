package com.example.myrpc.api;

import java.util.List;

public interface LoadBalancer {

    String select(List<String> urls);

}
