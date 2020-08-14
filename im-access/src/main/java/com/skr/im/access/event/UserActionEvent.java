package com.skr.im.access.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;


/**
 * @author : mengqingwen 
 * create at:  2020-07-22
 * @description:
 * */
public class UserActionEvent extends ApplicationEvent {

    @Getter
    private String userId;

    @Getter
    private String userName;

    @Getter
    private Object msg;

    protected UserActionEvent(Object source, String userId){
        super(source);
        this.userId = userId;
    }

    protected UserActionEvent(Object source, String userId, Object msg){
        super(source);
        this.userId = userId;
        this.msg = msg;
    }

}