package com.skr.im.access.handler.impl;

import com.skr.im.access.handler.MsgAsyncHandler;
import com.skr.im.access.service.UserService;
import com.skr.im.access.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mqw
 * @create 2020-07-24-10:44
 */
@Service
public class MsgTextHandler implements MsgAsyncHandler<String> {

    @Autowired
    UserService userService;

    @Override
    public void handle(String str) {
        if(!str.contains(Constants.REGEX_FLAG)){
            throw new RuntimeException("格式非法");
        }
        String[] split = str.split(Constants.REGEX_FLAG);
        if(split[0].equals(Constants.OP_LOGIN_FLAG)){

        }
    }
}