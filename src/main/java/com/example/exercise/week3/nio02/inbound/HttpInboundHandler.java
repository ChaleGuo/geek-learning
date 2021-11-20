package com.example.exercise.week3.nio02.inbound;


import com.example.exercise.week3.nio02.filter.HttpRequestFilter;
import com.example.exercise.week3.nio02.outbound.httpclient4.HttpOutboundHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class HttpInboundHandler extends ChannelInboundHandlerAdapter {

    private static Logger logger = LoggerFactory.getLogger(HttpInboundHandler.class);
    private final List<String> proxyServer;
    private HttpOutboundHandler handler;
    private List<HttpRequestFilter> filters = new ArrayList<>();

    public HttpInboundHandler(List<String> proxyServer) {
        this.proxyServer = proxyServer;
        this.handler = new HttpOutboundHandler(this.proxyServer);

//        filters = Arrays.asList(new HeaderHttpRequestFilter(),new DecryptRequestFilter());
        //使用ServiceLoader注入filter实现类
        ServiceLoader<HttpRequestFilter> load = ServiceLoader.load(HttpRequestFilter.class);
        for (HttpRequestFilter filter : load) {
            logger.info("add RequestFilter:{}", filter.getClass().getSimpleName());
            filters.add(filter);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            //logger.info("channelRead流量接口请求开始，时间为{}", startTime);
            FullHttpRequest fullRequest = (FullHttpRequest) msg;
            handler.handle(fullRequest, ctx, filters);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

}
