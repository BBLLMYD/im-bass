package com.skr.im.access.boot;

import com.skr.im.access.config.ReactorServiceRegister;
import com.skr.im.access.enumz.UserActionEnum;
import com.skr.im.access.event.EventGenerator;
import com.skr.im.access.event.impl.UserChatPrivateEvent;
import com.skr.im.access.utils.SpringContextHolder;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import reactor.core.Reactor;
import reactor.event.Event;


/**
 * @author : mengqingwen 
 * create at:  2020-07-15
 * @description:
 * */
@Slf4j
@ChannelHandler.Sharable
public class IMMsgAccessHandler  extends SimpleChannelInboundHandler<WebSocketFrame>{

    private Reactor reactor;

    public IMMsgAccessHandler(boolean autoRelease, Reactor reactor){
        super(autoRelease);
        this.reactor = reactor;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, WebSocketFrame msg) {
        Object data;
        if(msg instanceof TextWebSocketFrame){
            data = ((TextWebSocketFrame) msg).text();
        }else if(msg instanceof BinaryWebSocketFrame){
            data = msg.content().array();
        }else {
            ctx.close();
            return;
        }
        String longText = ctx.channel().id().asLongText();
        reactor.notify(ReactorServiceRegister.IM_EVENT_REACTION_LISTENER,
                Event.wrap(new UserChatPrivateEvent(longText,data)));
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        String longText = ctx.channel().id().asLongText();
        ApplicationEvent event = EventGenerator.buildEvent(UserActionEnum.GO_ONLINE, longText, ctx.channel());
        SpringContextHolder.publishEvent(event);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        String longText = ctx.channel().id().asLongText();
        ApplicationEvent event = EventGenerator.buildEvent(UserActionEnum.GO_OFFLINE, longText, ctx.channel());
        SpringContextHolder.publishEvent(event);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

}