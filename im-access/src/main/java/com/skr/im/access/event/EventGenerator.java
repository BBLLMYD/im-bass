package com.skr.im.access.event;

import com.skr.im.access.enumz.UserActionEnum;
import org.springframework.context.ApplicationEvent;

/**
 * @author mqw
 * @create 2020-07-22-19:02
 */
public class EventGenerator {

    public static ApplicationEvent buildEvent(UserActionEnum actionEnum, String userId, Object source){
        if(UserActionEnum.GO_ONLINE.equals(actionEnum)){
            return new UserGoOnlineEvent(source,userId);
        }else if(UserActionEnum.GO_OFFLINE.equals(actionEnum)){
            return new UserGoOffLineEvent(source,userId);
        }
        return null;
    }

}