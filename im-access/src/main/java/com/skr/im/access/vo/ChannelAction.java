package com.skr.im.access.vo;

import com.skr.im.access.enumz.UserActionEnum;
import io.netty.channel.Channel;
import lombok.Builder;
import lombok.Data;

/**
 * @author mqw
 * @create 2020-08-16-21:06
 */
@Data
@Builder
public class ChannelAction {

    UserActionEnum userActionEnum;
    Channel channel;

    Object data;

}