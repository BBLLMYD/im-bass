package com.skr.im.access.handler.impl;
import com.skr.im.access.handler.MsgAsyncHandler;
import com.skr.im.access.service.UserService;
import com.skr.im.access.utils.Constants;
import io.netty.channel.Channel;
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
    public void handle(String str, Channel channel) {
        if(!str.contains(Constants.REGEX_FLAG)){
            throw new RuntimeException("格式非法");
        }
        String[] split = str.split(Constants.REGEX_FLAG);
        String opFlag = split[0];
        String msg = split[1];
        if(opFlag.equals(Constants.OP_LOGIN_FLAG) && userService.auth(msg)){
            // login
        }
    }
}