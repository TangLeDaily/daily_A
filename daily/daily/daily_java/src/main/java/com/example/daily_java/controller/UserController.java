package com.example.daily_java.controller;

import com.example.daily_java.api.code.CommonCode;
import com.example.daily_java.api.model.ReturnModel;
import com.example.daily_java.api.utils.StringUtil;
import com.example.daily_java.entity.EmailCode;
import com.example.daily_java.entity.User;
import com.example.daily_java.service.UserService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;
import java.util.Random;



@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;


    // 加解密
    private static final byte[] DES_KEY = { 21, 1, -110, 82, -32, -85, -128, -65 };
    @SuppressWarnings("restriction")
    public static String encryptBasedDes(String data) {
        String encryptedData = null;
        try {
            // DES算法要求有一个可信任的随机数源
            SecureRandom sr = new SecureRandom();
            DESKeySpec deskey = new DESKeySpec(DES_KEY);
            // 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(deskey);
            // 加密对象
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, key, sr);
            // 加密，并把字节数组编码成字符串
            encryptedData = new sun.misc.BASE64Encoder().encode(cipher.doFinal(data.getBytes()));
        } catch (Exception e) {
            // log.error("加密错误，错误信息：", e);
            throw new RuntimeException("加密错误，错误信息：", e);
        }
        return encryptedData;
    }
    @SuppressWarnings("restriction")
    public static String decryptBasedDes(String cryptData) {
        String decryptedData = null;
        try {
            // DES算法要求有一个可信任的随机数源
            SecureRandom sr = new SecureRandom();
            DESKeySpec deskey = new DESKeySpec(DES_KEY);
            // 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(deskey);
            // 解密对象
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, key, sr);
            // 把字符串进行解码，解码为为字节数组，并解密
            decryptedData = new String(cipher.doFinal(new sun.misc.BASE64Decoder().decodeBuffer(cryptData)));
        } catch (Exception e) {
            throw new RuntimeException("解密错误，错误信息：", e);
        }
        return decryptedData;
    }
    //获取随机code
    public static String getRandomCode(){
        int num=0;
        for(int i=0;i<6;i++){
            num = num*10 + (int)(Math.random()*10+1);
        }
        return num + "";
    }


    @PostMapping
    @ResponseBody
    @RequestMapping("/login")
    public ReturnModel userLogin(@RequestBody User user) throws JSONException {

        String username = user.getUsername();
        String password = user.getPassword();
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

    @ResponseBody
    @RequestMapping("/checkReal")
    public ReturnModel checkReal(@RequestBody User user) throws JSONException {

        String username = user.getUsername();
        String email = user.getEmail();
        if(StringUtil.isNullOrEmpty(username)){
            return new ReturnModel(CommonCode.FAIL_CODE, CommonCode.EMPTY_DATA, CommonCode.MISSING_PARAM_MSG);
        }
        if(StringUtil.isNullOrEmpty(email)){
            return new ReturnModel(CommonCode.FAIL_CODE, CommonCode.EMPTY_DATA, CommonCode.MISSING_PARAM_MSG);
        }
        //deal service
        boolean is_real = userService.checkReal(username,email);
        if(is_real){
            return new ReturnModel(CommonCode.SUCCESS_CODE, CommonCode.EMPTY_DATA, CommonCode.SUCCESS_MSG);

        }
        else{
            return new ReturnModel(CommonCode.NO_FOUND_USER_CODE,CommonCode.EMPTY_DATA,CommonCode.NO_FOUND_USER_MSG);
        }
    }

    @ResponseBody
    @RequestMapping("/getCode")
    public ReturnModel getCode(@RequestBody String email) throws JSONException {

        if(StringUtil.isNullOrEmpty(email)){
            return new ReturnModel(CommonCode.FAIL_CODE, CommonCode.EMPTY_DATA, CommonCode.MISSING_PARAM_MSG);
        }
        boolean is_true = userService.sendCode(email, getRandomCode());
        if(is_true){
            return new ReturnModel(CommonCode.SUCCESS_CODE, "success", CommonCode.SUCCESS_MSG);
        }
        else{
            return new ReturnModel(CommonCode.FAIL_CODE, "failed", CommonCode.MISSING_PARAM_MSG);
        }
    }

    @ResponseBody
    @RequestMapping("/checkUser")
    public ReturnModel checkUser(@RequestBody String username) throws JSONException {

        if(StringUtil.isNullOrEmpty(username)){
            return new ReturnModel(CommonCode.FAIL_CODE, CommonCode.EMPTY_DATA, CommonCode.MISSING_PARAM_MSG);
        }
        boolean is_true = userService.checkUser(username);
        if(is_true){
            return new ReturnModel(CommonCode.SUCCESS_CODE, "success", CommonCode.SUCCESS_MSG);
        }
        else{
            return new ReturnModel(CommonCode.FAIL_CODE, "failed", CommonCode.MISSING_PARAM_MSG);
        }
    }

    @ResponseBody
    @RequestMapping("/checkCode")
    public ReturnModel checkCode(@RequestBody EmailCode email_code) throws JSONException {

        if(StringUtil.isNullOrEmpty(email_code.getCode())){
            return new ReturnModel(CommonCode.FAIL_CODE, "eeeee"/*CommonCode.EMPTY_DATA*/, CommonCode.MISSING_PARAM_MSG);
        }
        boolean is_true = userService.checkCode(email_code.getEmail(), email_code.getCode());
        if(is_true){
            return new ReturnModel(CommonCode.SUCCESS_CODE, "success", CommonCode.SUCCESS_MSG);
        }
        else{
            return new ReturnModel(CommonCode.FAIL_CODE, "failed", CommonCode.MISSING_PARAM_MSG);
        }
    }

    @ResponseBody
    @RequestMapping("/register")
    public ReturnModel register(@RequestBody User user) throws JSONException {

        if(StringUtil.isNullOrEmpty(user.getUsername())){
            return new ReturnModel(CommonCode.FAIL_CODE, "eeeee"/*CommonCode.EMPTY_DATA*/, CommonCode.MISSING_PARAM_MSG);
        }
        boolean is_true = userService.register(user);
        if(is_true){
            return new ReturnModel(CommonCode.SUCCESS_CODE, "success", CommonCode.SUCCESS_MSG);
        }
        else{
            return new ReturnModel(CommonCode.FAIL_CODE, "failed", CommonCode.MISSING_PARAM_MSG);
        }
    }


    @ResponseBody
    @RequestMapping("/chongZhi")
    public ReturnModel chongZhi(@RequestBody User user) throws JSONException {

        if(StringUtil.isNullOrEmpty(user.getUsername())){
            return new ReturnModel(CommonCode.FAIL_CODE, "eeeee"/*CommonCode.EMPTY_DATA*/, CommonCode.MISSING_PARAM_MSG);
        }
        boolean is_true = userService.chongZhi(user.getUsername(), user.getPassword());
        if(is_true){
            return new ReturnModel(CommonCode.SUCCESS_CODE, "success", CommonCode.SUCCESS_MSG);
        }
        else{
            return new ReturnModel(CommonCode.FAIL_CODE, "failed", CommonCode.MISSING_PARAM_MSG);
        }
    }
}
