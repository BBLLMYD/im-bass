package com.skr.im.access.handler.impl;

import com.skr.im.access.handler.MsgAsyncHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.stereotype.Service;

/**
 * @author mqw
 * @create 2020-07-24-10:44
 */
@Service
public class MsgTextHandler implements MsgAsyncHandler<TextWebSocketFrame> {

    @Override
    public void handle(TextWebSocketFrame textWebSocketFrame) {
        System.err.println("收到文本消息。。。");
        String text = textWebSocketFrame.text();
        String[] split = text.split("\n");
        for (String s : split) {
            System.err.println(s);
        }
    }

}