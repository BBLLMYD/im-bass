package com.skr.im.access.boot.holder;

import io.netty.channel.Channel;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author : mengqingwen 
 * create at:  2020-07-15
 * @description:
 * */
public class MetaDataHolder {

    private static final ConcurrentHashMap<String, Channel> channelIdMap = new ConcurrentHashMap<>();


    public static void channelOnLine(String channelId,Channel channel){
        channelIdMap.put(channelId,channel);
    }

    public static void channelOffLine(String channelId){
        Channel remove = channelIdMap.remove(channelId);
    }



    public static void userLogin(String userId,Channel channel){
    }

    public static void userLogout(String userId,Channel channel){
    }

    public static void msgToUser(String userFrom, String msg, String userTo){
        new TextWebSocketFrame(msg);
    }

    public static boolean userIsOnline(String userId){
        return channelIdMap.containsKey(userId);
    }

    public static Set<String> onLineUsers(){
        ConcurrentHashMap.KeySetView<String, Channel> strings = channelIdMap.keySet();
        return strings;
    }


}