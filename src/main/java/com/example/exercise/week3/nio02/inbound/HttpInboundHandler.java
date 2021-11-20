package com.example.exercise.week3.nio02.inbound;


import com.example.exercise.week3.nio02.filter.DecryptRequestFilter;
import com.example.exercise.week3.nio02.filter.HeaderHttpRequestFilter;
import com.example.exercise.week3.nio02.filter.HttpRequestFilter;
import com.example.exercise.week3.nio02.outbound.httpclient4.HttpOutboundHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import java.util.*;

public class HttpInboundHandler extends ChannelInboundHandlerAdapter {

    private static Logger logger = LoggerFactory.getLogger(HttpInboundHandler.class);
    private final List<String> proxyServer;
    private HttpOutboundHandler handler;
//    private HttpRequestFilter filter = new HeaderHttpRequestFilter();
    private List<HttpRequestFilter> filters;

    public HttpInboundHandler(List<String> proxyServer) {
        this.proxyServer = proxyServer;
        this.handler = new HttpOutboundHandler(this.proxyServer);

        filters = Arrays.asList(new HeaderHttpRequestFilter(),new DecryptRequestFilter());
//        ServiceLoader<HttpRequestFilter> load = ServiceLoader.load(HttpRequestFilter.class);
//        Iterator<HttpRequestFilter> iterator = load.iterator();
//        if (iterator.hasNext()) {
//            HttpRequestFilter filter = iterator.next();
//            logger.info("add HttpRequestFilter:{}", filter.getClass().getName());
//            filters.add(filter);
//        }
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
    
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

}
