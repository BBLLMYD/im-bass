package com.skr.im.access.boot;

import com.skr.im.access.config.ReactorServiceRegister;
import com.skr.im.access.enumz.UserActionEnum;
import com.skr.im.access.event.EventGenerator;
import com.skr.im.access.event.impl.UserChatPrivateEvent;
import com.skr.im.access.utils.SpringContextHolder;
import com.skr.im.access.vo.ChannelAction;
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
public class IMMsgAccessWSHandler extends SimpleChannelInboundHandler<WebSocketFrame>{

    private Reactor reactor;

    public IMMsgAccessWSHandler(boolean autoRelease, Reactor reactor){
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
        ChannelAction channelAction = ChannelAction.builder()
                .channel(ctx.channel())
                .userActionEnum(UserActionEnum.CHAT_PRIVATE)
                .data(data)
                .build();

        reactor.notify(ReactorServiceRegister.IM_EVENT_REACTION_LISTENER,
                Event.wrap(new UserChatPrivateEvent(channelAction)));
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        ChannelAction channelAction = ChannelAction.builder().channel(ctx.channel()).userActionEnum(UserActionEnum.GO_ONLINE).build();
        ApplicationEvent event = EventGenerator.buildEvent(channelAction);
        SpringContextHolder.publishEvent(event);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        ChannelAction channelAction = ChannelAction.builder().channel(ctx.channel()).userActionEnum(UserActionEnum.GO_OFFLINE).build();
        ApplicationEvent event = EventGenerator.buildEvent(channelAction);
        SpringContextHolder.publishEvent(event);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

}