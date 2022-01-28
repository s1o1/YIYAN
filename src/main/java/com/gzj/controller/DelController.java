package com.gzj.controller;

import com.gzj.service.DelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class DelController {
    @Autowired
    private DelService delService;
    @RequestMapping("/del")
    public String del(){
        return "del";
    }
    @RequestMapping(value = "/del_file",method = RequestMethod.POST)
    public String delFile(String filename, Model model){
        String msg = delService.delFile(filename);
        model.addAttribute("msg",msg);
        return "del";
    }
}
