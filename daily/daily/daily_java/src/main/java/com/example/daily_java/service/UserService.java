package com.example.daily_java.service;


import com.example.daily_java.entity.User;
import com.example.daily_java.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;


public interface UserService {
    public User userLogin(String username, String password);
    public boolean sendCode(String email, String code);
    public boolean checkCode(String email, String code);
    public boolean register(User user);
    public boolean checkUser(String username);
    public boolean checkReal(String username, String email);
    public boolean chongZhi(String username, String password);
}
