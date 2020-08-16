package com.skr.im.access.event.impl;


import com.skr.im.access.event.UserActionEvent;
import com.skr.im.access.vo.ChannelAction;

/**
 * @author : mengqingwen 
 * create at:  2020-07-22
 * @description:
 * */
public class UserLineEvent extends UserActionEvent {

    public UserLineEvent(ChannelAction channelAction){
        super(channelAction);
    }

}