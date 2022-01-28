package com.gzj.controller;

import com.gzj.service.YPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 福利主页
 */
@Controller
public class YpicController {
    @Autowired
    private YPicService yPicService;
    @RequestMapping("/y_picture")
    public String ypic(@RequestParam(value = "page",defaultValue = "1")int index, Model model){
        Map<String, Object> map = yPicService.getYPics(index);
        model.addAttribute("pics",map.get("pics"));
        model.addAttribute("page",map.get("index"));
        return "ypic";
    }
}
