package com.skr.im.server.boot;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import static io.netty.handler.codec.http.HttpHeaderNames.CONTENT_LENGTH;
import static io.netty.handler.codec.http.HttpHeaderNames.CONTENT_TYPE;

/**
 * @author : mengqingwen 
 * create at:  2020-07-12
 * @description:
 * */
public class HttpTest extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object httpObject) throws Exception {

        if(httpObject instanceof FullHttpRequest) {
            ByteBuf byteBuf = Unpooled.copiedBuffer("老子收到了"+Thread.currentThread().getName()+"->"+Thread.currentThread().getId(), CharsetUtil.UTF_8);
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, byteBuf);
            response.headers().set(CONTENT_TYPE, "application/json");
            response.headers().set(CONTENT_LENGTH, byteBuf.readableBytes());
            response.headers().set("Thread",Thread.currentThread().getId()+","+Thread.currentThread().getName());
            channelHandlerContext.writeAndFlush(response);
        }else {
            // 不规范请求直接关闭
            channelHandlerContext.channel().close();
        }
    }

}