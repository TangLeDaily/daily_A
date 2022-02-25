package com.example.daily_java.service;

import com.example.daily_java.entity.User;
import com.example.daily_java.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl {

    @Autowired
    UserMapper userMapper;

    public User userLogin(String username, String password){
        return userMapper.userLogin(username,password);
    }
}
