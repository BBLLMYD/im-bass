package com.skr.im.access.handler;


import io.netty.channel.Channel;
import io.netty.util.ReferenceCountUtil;

/**
 * @author mqw
 * @create 2020-07-24-10:47
 */
public interface MsgAsyncHandler<T> {

    default void deal(T t, Channel channel){
        try {
            handle(t,channel);
        }finally {
            // 内存释放
            ReferenceCountUtil.release(t);
        }
    }

    void handle(T t,Channel channel);

}
