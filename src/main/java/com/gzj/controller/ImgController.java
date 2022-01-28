package com.gzj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 图片最终展示页面
 */
@Controller
public class ImgController {
    @RequestMapping("/img")
    public String img(@RequestParam("url")String url, @RequestParam("name")String name, Model model){
        model.addAttribute("url",url);
        model.addAttribute("name",name);
        return "img";
    }
}
