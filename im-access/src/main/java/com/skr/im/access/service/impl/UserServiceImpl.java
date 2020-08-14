package com.skr.im.access.service.impl;

import com.skr.im.access.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

/**
 * @author mqw
 * @create 2020-08-14-16:28
 */
@Service
public class UserServiceImpl implements UserService {

    @Value("${userIds}")
    String users;

    List<String> userList;

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
    }

}