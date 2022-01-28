package com.gzj.controller;

import com.gzj.dao.pojo.User;
import com.gzj.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/user_login")
    public String userLogin(User user, Model model, HttpSession session){
        String msg = loginService.userLogin(user,session);
        model.addAttribute("msg",msg);
        return "login";
    }
}
