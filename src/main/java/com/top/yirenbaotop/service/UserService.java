package com.top.yirenbaotop.service;

import com.top.yirenbaotop.domain.User;
import com.top.yirenbaotop.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
     private UserMapper userMapper;

    public int register(User user){
        return userMapper.register(user);
    }

    public User loadByAccount(String account){
        return userMapper.loadByAccount(account);
    }

    public User login(User user){
        return userMapper.login(user);
    }
}
