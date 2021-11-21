package com.example.exercise.week3.nio02.router;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 轮询路由
 */
@Slf4j
public class PollingHttpEndpointRouter implements HttpEndpointRouter {
    private final AtomicInteger index = new AtomicInteger(0);

    @Override
    public String route(List<String> urls) {
        if (index.get() > urls.size() - 1) {
            index.set(0);
        }
        String url = urls.get(index.getAndIncrement());
        log.info("route to url={}", url);
        return url;
    }
}
