package com.skr.im.access.event.impl;


import com.skr.im.access.event.UserActionEvent;

/**
 * @author : mengqingwen 
 * create at:  2020-07-22
 * @description:
 * */
public class UserGoOffLineEvent extends UserActionEvent {

    public UserGoOffLineEvent(Object source,String userId){
        super(source,userId);
    }

}