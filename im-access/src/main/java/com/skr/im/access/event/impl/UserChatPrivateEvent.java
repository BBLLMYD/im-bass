package com.skr.im.access.event.impl;

import com.skr.im.access.event.UserActionEvent;

/**
 * @author mqw
 * @create 2020-07-23-16:04
 */
public class UserChatPrivateEvent extends UserActionEvent {

    public UserChatPrivateEvent(String userId, Object msg) {
        super(UserChatPrivateEvent.class, userId, msg);
    }

}