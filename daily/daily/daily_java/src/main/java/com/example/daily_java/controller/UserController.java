package com.example.daily_java.controller;

import com.example.daily_java.api.code.CommonCode;
import com.example.daily_java.api.model.ReturnModel;
import com.example.daily_java.api.utils.StringUtil;
import com.example.daily_java.common.ApiResult;
import com.example.daily_java.entity.User;
import com.example.daily_java.service.UserService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Console;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    @ResponseBody
    @RequestMapping("/login")
    public ReturnModel userLogin(@RequestBody JSONObject jsonObject) throws JSONException {

        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        if(true){
            return new ReturnModel(-1,username,password);
        }
        if(StringUtil.isNullOrEmpty(username)){
            return new ReturnModel(CommonCode.FAIL_CODE, CommonCode.EMPTY_DATA, CommonCode.MISSING_PARAM_MSG);
        }
        if(StringUtil.isNullOrEmpty(password)){
            return new ReturnModel(CommonCode.FAIL_CODE, CommonCode.EMPTY_DATA, CommonCode.MISSING_PARAM_MSG);
        }
        //deal service
        User users = userService.userLogin(username,password);
        if(users == null){
            return new ReturnModel(CommonCode.NO_FOUND_USER_CODE,CommonCode.EMPTY_DATA,CommonCode.NO_FOUND_USER_MSG);
        }
        return new ReturnModel(CommonCode.SUCCESS_CODE, users, CommonCode.SUCCESS_MSG);
    }
}
