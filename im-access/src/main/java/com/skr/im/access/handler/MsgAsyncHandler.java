package com.skr.im.access.handler;


/**
 * @author mqw
 * @create 2020-07-24-10:47
 */
public interface MsgAsyncHandler<T> {

    void handle(T t);

}
