package com.skr.im.access.handler.impl;

import com.skr.im.access.handler.MsgAsyncHandler;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import org.springframework.stereotype.Service;

/**
 * @author mqw
 * @create 2020-07-24-10:44
 */
@Service
public class MsgBinaryHandler implements MsgAsyncHandler<BinaryWebSocketFrame> {

    @Override
    public void handle(BinaryWebSocketFrame binaryWebSocketFrame) {
        ByteBuf content = binaryWebSocketFrame.content();
        content.array();
    }

}