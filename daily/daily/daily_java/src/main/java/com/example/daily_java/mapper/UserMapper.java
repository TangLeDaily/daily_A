package com.example.daily_java.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.daily_java.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper{
    User userLogin(@Param("username") String username, @Param("password")String password);
}
