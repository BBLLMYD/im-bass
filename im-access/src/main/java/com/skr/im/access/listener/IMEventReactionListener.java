package com.skr.im.access.listener;

import com.skr.im.access.event.impl.UserChatPrivateEvent;
import org.springframework.stereotype.Component;
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
        // 此处根据协议约定内容处理逻辑
        System.out.println(msg);
    }

}