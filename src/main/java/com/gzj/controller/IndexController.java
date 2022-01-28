package com.gzj.controller;
import com.gzj.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;

/**
 * 首页
 */
@Controller
public class IndexController {
    @Autowired
    private IndexService indexService;
    @RequestMapping("/")
    public String index(@RequestParam(value = "page",defaultValue = "1")int index, Model model){
        Map<String, Object> map = indexService.getPics(index);
        model.addAttribute("pics",map.get("pics"));
        model.addAttribute("page",map.get("index"));
        return "index";
    }

}
