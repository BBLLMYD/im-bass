package com.skr.im.access.listener;

import com.skr.im.access.event.UserActionEvent;
import com.skr.im.access.event.impl.UserChatPrivateEvent;
import org.springframework.stereotype.Component;
import reactor.event.Event;
import reactor.function.Consumer;

/**
 * @author mqw
 * @create 2020-07-22-17:56
 */
@Component
public class IMEventReactionListener implements Consumer<UserChatPrivateEvent> {

    @Override
    public void accept(UserChatPrivateEvent userChatPrivateEvent) {
        Object msg = userChatPrivateEvent.getMsg();
        System.out.println(msg);
    }

}