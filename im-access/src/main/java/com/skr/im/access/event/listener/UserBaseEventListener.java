package com.skr.im.access.event.listener;

import com.skr.im.access.boot.holder.MetaDataHolder;
import com.skr.im.access.enumz.UserActionEnum;
import com.skr.im.access.event.impl.UserLineEvent;
import io.netty.channel.Channel;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author mqw
 * @create 2020-07-22-17:56
 */
@Component
public class UserBaseEventListener {

    @EventListener(classes = UserLineEvent.class)
    public void onUserGoOnLine(UserLineEvent userlineEvent){

        Channel channel = userlineEvent.getChannel();

        if(userlineEvent.getChannelAction().getUserActionEnum() == UserActionEnum.GO_ONLINE){
            MetaDataHolder.channelOnLine(channel.id().asLongText(),channel);
        }

        if(userlineEvent.getChannelAction().getUserActionEnum() == UserActionEnum.GO_OFFLINE){
            MetaDataHolder.channelOffLine(channel.id().asLongText());
        }

    }


}