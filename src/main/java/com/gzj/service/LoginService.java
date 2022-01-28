package com.gzj.service;

import com.gzj.dao.pojo.User;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface LoginService {
    /**
     * 根据用户名登录
     * @param user  用户
     * @return      登陆结果
     */
    String userLogin(User user, HttpSession session);
}
