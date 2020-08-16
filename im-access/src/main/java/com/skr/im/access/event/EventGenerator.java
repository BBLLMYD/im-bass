package com.skr.im.access.event;

import com.skr.im.access.event.impl.UserLineEvent;
import com.skr.im.access.vo.ChannelAction;

/**
 * @author mqw
 * @create 2020-07-22-19:02
 */
public class EventGenerator {

    public static UserActionEvent buildEvent(ChannelAction channelAction){
        if(channelAction.getChannel() == null || channelAction.getUserActionEnum() == null){
            throw new RuntimeException("异常channelAction" + channelAction);
        }
        return new UserLineEvent(channelAction);
    }

}