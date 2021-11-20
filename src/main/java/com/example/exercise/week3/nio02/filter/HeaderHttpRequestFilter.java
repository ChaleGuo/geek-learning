package com.example.exercise.week3.nio02.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

@Slf4j
public class HeaderHttpRequestFilter implements HttpRequestFilter {

    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        log.info("request filter: add header mao");
        fullRequest.headers().set("mao", "soul");
    }
}
