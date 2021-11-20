package com.example.exercise;

import com.example.exercise.week3.nio02.filter.HttpRequestFilter;
import lombok.extern.slf4j.Slf4j;

import java.util.ServiceLoader;

@Slf4j
public class ServiceLoaderTest {
    public static void main(String[] args) {
        ServiceLoader<HttpRequestFilter> load = ServiceLoader.load(HttpRequestFilter.class);
        for (HttpRequestFilter filter : load) {
            log.info("impl class:{}", filter.getClass().getName());
        }
    }
}
