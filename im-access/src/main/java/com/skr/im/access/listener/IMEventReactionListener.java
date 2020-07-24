package com.skr.im.access.listener;

import com.skr.im.access.event.impl.UserChatPrivateEvent;
import com.skr.im.access.handler.MsgAsyncHandler;
import com.skr.im.access.utils.SpringContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import reactor.function.Consumer;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author mqw
 * @create 2020-07-22-17:56
 */
@Component
@Slf4j
@DependsOn("springContextHolder")
public class IMEventReactionListener implements Consumer<UserChatPrivateEvent> {

    private static final ConcurrentHashMap<Class,MsgAsyncHandler> handlerMap = new ConcurrentHashMap<>();

    @Override
    public void accept(UserChatPrivateEvent userChatPrivateEvent) {
        Object msg = userChatPrivateEvent.getMsg();
        // 此处根据协议约定内容处理逻辑
        MsgAsyncHandler handler = getHandlerInstance(msg.getClass());
        handler.handle(msg);
    }


    /**
     * 方式2
     * @param paramType
     * @return
     */
    private MsgAsyncHandler getHandlerInstance(Class<?> paramType){
        if(handlerMap.containsKey(paramType)){
            return handlerMap.get(paramType);
        }
        Map<String, MsgAsyncHandler> beans = SpringContextHolder.getApplicationContext().getBeansOfType(MsgAsyncHandler.class);
        for (Map.Entry<String, MsgAsyncHandler> entry : beans.entrySet()) {
            MsgAsyncHandler msgAsyncHandler = entry.getValue();
            Class<? extends MsgAsyncHandler> aClass = msgAsyncHandler.getClass();
            try {
                Method method = aClass.getMethod("handle", paramType);
                if(Objects.nonNull(method)){
                    handlerMap.put(paramType,msgAsyncHandler);
                    return msgAsyncHandler;
                }
            } catch (NoSuchMethodException ignored) {
            }
        }
        throw new RuntimeException("could not find handler 4 type :" + paramType);
    }

}