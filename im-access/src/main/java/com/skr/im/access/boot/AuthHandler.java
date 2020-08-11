package com.skr.im.access.boot;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;
import org.springframework.stereotype.Component;


import static io.netty.handler.codec.http.HttpHeaderNames.CONTENT_LENGTH;
import static io.netty.handler.codec.http.HttpHeaderNames.CONTENT_TYPE;

/**
 * @author : mengqingwen 
 * create at:  2020-07-12
 * @description:
 * */
@ChannelHandler.Sharable
@Component
public class AuthHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object httpObject) throws Exception {

        if(httpObject instanceof FullHttpRequest) {
            FullHttpRequest httpRequest = (FullHttpRequest) httpObject;
            String uri = httpRequest.uri();
            String id = channelHandlerContext.channel().id().asShortText();
            ByteBuf byteBuf = Unpooled.copiedBuffer(id, CharsetUtil.UTF_8);
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, byteBuf);
            response.headers().set(CONTENT_TYPE, "application/text");
            response.headers().set(CONTENT_LENGTH, byteBuf.readableBytes());
            channelHandlerContext.channel().writeAndFlush(response);
        }else {
            channelHandlerContext.channel().close();
        }

    }


}