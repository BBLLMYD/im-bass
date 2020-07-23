package com.skr.im.access.listener;

import com.skr.im.access.event.impl.UserGoOffLineEvent;
import com.skr.im.access.event.impl.UserGoOnlineEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author mqw
 * @create 2020-07-22-17:56
 */
@Component
public class UserBaseEventListener {

    @EventListener(classes = UserGoOnlineEvent.class)
    public void onUserGoOnLine(UserGoOnlineEvent userGoOnlineEvent){
        System.err.println("UserEventListener="+userGoOnlineEvent);
    }

    @EventListener(classes = UserGoOffLineEvent.class)
    public void onUserGoOffLine(UserGoOffLineEvent userGoOffLineEvent){
        System.err.println("UserGoOffLineEvent="+userGoOffLineEvent);
    }

}