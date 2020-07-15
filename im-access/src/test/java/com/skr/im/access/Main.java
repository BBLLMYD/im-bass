package com.skr.im.access;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : mengqingwen 
 * create at:  2020-07-15
 * @description:
 * */
public class Main {

    public static void main(String[] args) {

        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("adad","qwe");
        concurrentHashMap.put("ada2d","qwe");
        concurrentHashMap.put("ad3ad","qwe");
        ConcurrentHashMap.KeySetView<String, String> strings = concurrentHashMap.keySet();
        String zxc = concurrentHashMap.remove("ad3ad");
        System.out.println(zxc);
    }

}