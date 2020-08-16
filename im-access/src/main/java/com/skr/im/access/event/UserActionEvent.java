package com.skr.im.access.event;

import com.skr.im.access.vo.ChannelAction;
import io.netty.channel.Channel;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;


/**
 * @author : mengqingwen 
 * create at:  2020-07-22
 * @description:
 * */
public abstract class UserActionEvent extends ApplicationEvent {

    @Getter
    private String channelId;

    @Getter
    private Channel channel;

    @Getter
    private ChannelAction channelAction;

    protected UserActionEvent(ChannelAction channelAction){
        super(channelAction);
        this.channelAction = channelAction;
        this.channel = channelAction.getChannel();
        this.channelId = channel.id().asLongText();
    }


}