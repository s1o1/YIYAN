package com.gzj.controller;
import com.gzj.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;


@Controller
public class UploadController {
    @Autowired
    private UploadService uploadService;
    @RequestMapping("/upload")
    public String upload(Model model){
        model.addAttribute("msg","点击上传图片");
        return "upload";
    }
    @RequestMapping(value = "/upload_pic",method = RequestMethod.POST)
    public String upload_file(@RequestParam("pic") MultipartFile file, Model model,boolean yy){
        String msg = uploadService.upload_file(file,yy);
        model.addAttribute("msg",msg);
        return "upload";
    }
}
