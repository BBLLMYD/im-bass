package com.skr.im.access.boot.holder;

import io.netty.channel.Channel;
import io.netty.channel.ChannelPromise;

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

    private static final ConcurrentHashMap<String, Channel> userChannelMap = new ConcurrentHashMap<>();


    private static final Set<String> userRegister = new CopyOnWriteArraySet<>();

    public static void userOnLine(String userId,Channel channel){
        userChannelMap.put(userId,channel);
    }

    public static void userOffLine(String userId){
        Channel remove = userChannelMap.remove(userId);
    }

    public static void userForceOffLine(String userId){
        Channel remove = userChannelMap.remove(userId);
        if(Objects.nonNull(remove)){
            remove.close();
        }
    }

    public static boolean isOnline(String userId){
        return userChannelMap.containsKey(userId);
    }

    public static void userAdd(String userId){
        userRegister.add(userId);
    }

    public static Set<String> onLineUsers(){
        ConcurrentHashMap.KeySetView<String, Channel> strings = userChannelMap.keySet();
        return strings;
    }


}