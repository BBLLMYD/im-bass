package com.skr.im.access.handler.impl;

import com.skr.im.access.handler.MsgAsyncHandler;
import org.springframework.stereotype.Service;

/**
 * @author mqw
 * @create 2020-07-24-10:44
 */
@Service
public class MsgTextHandler implements MsgAsyncHandler<String> {

    @Override
    public void handle(String s) {
        String[] split = s.split("\n");
        for (String str : split) {
            System.err.println(str);
        }
    }
}