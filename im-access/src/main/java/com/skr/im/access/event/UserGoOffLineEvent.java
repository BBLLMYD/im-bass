package com.skr.im.access.event;


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