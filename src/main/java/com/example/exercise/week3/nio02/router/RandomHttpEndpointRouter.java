package com.example.exercise.week3.nio02.router;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;

@Slf4j
public class RandomHttpEndpointRouter implements HttpEndpointRouter {
    @Override
    public String route(List<String> urls) {
        int size = urls.size();
        Random random = new Random(System.currentTimeMillis());
        String url = urls.get(random.nextInt(size));
        log.info("route to url={}",url);
        return url;
    }
}
