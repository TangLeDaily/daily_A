package com.example.daily_java.service.Impl;

import com.example.daily_java.entity.User;
import com.example.daily_java.mapper.UserMapper;
import com.example.daily_java.service.UserService;
import com.example.daily_java.utils.email.CmsMailConfig;
import com.example.daily_java.utils.email.MailUtils;
import com.example.daily_java.utils.email.MailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User userLogin(String username, String password){
        User user = userMapper.userLogin(username,password);
        return user;
    }

    @Override
    public boolean sendCode(String email, String code){
        String content = "DailySpace邮箱验证码如下："+code+"<br>如果这不是你所申请的内容，请忽略本邮件";
        MailVo this_user = new MailVo("Dailyspace邮箱验证",content,email);
        userMapper.saveCode(email, code);
        return sendMails(this_user);
    }

    @Override
    public boolean checkCode(String email, String code){
        if(code.equals(userMapper.checkCode(email))){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean checkUser(String username){
        String uname = userMapper.checkUser(username);
        if(uname==null){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public boolean register(User user){
        userMapper.register(
                user.getUsername(),
                user.getPassword(),
                user.getName(),
                user.getEmail(),
                user.getPhone_number(),
                user.getProfilePicture());
        return true;
    }

    public boolean sendMails(MailVo mailVo) {
        if (null == mailVo) {
            return false;
        }
        // 获取当前正在使用的发件人配置
        CmsMailConfig sendAdmin = new CmsMailConfig(0,"dailyspace@163.com","CGCQISNVDNKHLIUT");
        MailUtils mailUtils= new MailUtils();
        try {
            // 发送邮件
            mailUtils.sendMail(Boolean.FALSE, mailVo, null, sendAdmin);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
