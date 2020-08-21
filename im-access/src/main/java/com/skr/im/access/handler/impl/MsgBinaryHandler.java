package com.skr.im.access.handler.impl;

import com.skr.im.access.handler.MsgAsyncHandler;
import io.netty.channel.Channel;
import org.springframework.stereotype.Service;

/**
 * @author mqw
 * @create 2020-07-24-10:44
 */
@Service
public class MsgBinaryHandler implements MsgAsyncHandler<Byte[]> {

    @Override
    public void handle(Byte[] bytes, Channel channel) {

    }
}