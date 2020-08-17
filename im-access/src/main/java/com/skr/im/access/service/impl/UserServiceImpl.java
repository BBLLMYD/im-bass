package com.skr.im.access.service.impl;

import com.skr.im.access.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author mqw
 * @create 2020-08-14-16:28
 */
@Service
public class UserServiceImpl implements UserService {

    @Value("${userIds}")
    String users;

    List<String> userList;

    Map<String, Queue> userMsg;

    @Override
    public boolean auth(String userName) {
        if(userList.contains(userName)){
            return true;
        }
        return false;
    }


    @PostConstruct
    void initData(){
        userList = Arrays.asList(users.split(","));
        ConcurrentHashMap<String, Queue> hashMap = new ConcurrentHashMap<>();
        userList.forEach(vo-> hashMap.put(vo,new LinkedBlockingQueue()));
        userMsg = hashMap;
    }

}