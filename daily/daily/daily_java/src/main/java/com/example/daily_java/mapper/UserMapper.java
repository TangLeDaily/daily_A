package com.example.daily_java.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.daily_java.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper{

    User userLogin(@Param("username") String username, @Param("password")String password);
    void saveCode(@Param("email") String email, @Param("code") String code);
    String checkCode(@Param("email") String email);
    String checkUser(@Param("username") String username);
    void register(
            @Param("username") String username,
            @Param("password") String password,
            @Param("name") String name,
            @Param("email") String email,
            @Param("phone_number") double phone_number,
            @Param("profilePicture") String profilePicture
            );
   // return userLogin;
}
