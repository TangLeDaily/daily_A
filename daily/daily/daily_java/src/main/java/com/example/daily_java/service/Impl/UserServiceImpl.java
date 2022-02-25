package com.example.daily_java.service.Impl;

import com.example.daily_java.entity.User;
import com.example.daily_java.mapper.UserMapper;
import com.example.daily_java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User userLogin(String username, String password){
        return userMapper.userLogin(username,password);
    }
}
