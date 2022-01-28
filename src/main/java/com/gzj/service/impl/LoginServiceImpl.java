package com.gzj.service.impl;

import com.gzj.dao.mapper.UserMapper;
import com.gzj.dao.pojo.User;
import com.gzj.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public String userLogin(User user, HttpSession session) {
        String username = user.getUsername();
        String pwd = user.getPwd();
        if(username == null || username.length() == 0){
            return "用户名为空！";
        }
        if(pwd == null || pwd.length() == 0){
            return "密码为空！";
        }
        User user1 = userMapper.queryUserByName(username);
        if(user1 == null){
            return "不存在该用户";
        }
        if(!user1.getPwd().equals(pwd)){
            return "密码错误";
        }
        session.setAttribute("user",username);
        return "登陆成功";
    }
}
