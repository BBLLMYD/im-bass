package com.skr.im.access.event.impl;

import com.skr.im.access.event.UserActionEvent;
import com.skr.im.access.vo.ChannelAction;

/**
 * @author mqw
 * @create 2020-07-23-16:04
 */
public class UserChatPrivateEvent extends UserActionEvent {

    public UserChatPrivateEvent(ChannelAction channelAction) {
        super(channelAction);
    }

}