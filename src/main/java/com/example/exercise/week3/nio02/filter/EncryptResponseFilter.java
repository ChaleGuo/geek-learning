package com.example.exercise.week3.nio02.filter;

import io.netty.handler.codec.http.FullHttpResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EncryptResponseFilter implements HttpResponseFilter {
    @Override
    public void filter(FullHttpResponse response) {
        log.info("response filter: 返回值加密");
    }
}
