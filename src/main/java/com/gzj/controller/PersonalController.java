package com.gzj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonalController {
    @RequestMapping("personal_message")
    public String personal(){
        return "personal_message";
    }
}
