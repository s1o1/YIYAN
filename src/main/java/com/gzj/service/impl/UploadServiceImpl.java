package com.gzj.service.impl;

import com.gzj.config.QNYConfig;
import com.gzj.dao.mapper.PicMapper;
import com.gzj.dao.pojo.Pic;
import com.gzj.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

import java.sql.Timestamp;

@Service
public class UploadServiceImpl implements UploadService {
    @Autowired
    private PicMapper picMapper;
    @Autowired
    private QNYConfig qnyConfig;
    @Override
    public String upload_file(MultipartFile file,boolean yy) {
        String filename = file.getOriginalFilename();
        if(filename==null||filename.length()==0){
            return "文件为空";
        }
        String[] names = filename.split("\\.");
        String suffix = null;
        String name = null;
        if(names.length==2){
            if(names[1].equals("jpg")||names[1].equals("png")||names[1].equals("gif")){
                name = names[0];
                suffix = "image/"+names[1];
            }else {
                return "上传失败，上传图片格式仅支持jpg,png,gif";
            }
        }else {
            return "文件名中出现了 . ,解析失败！";
        }
        //文件上传
        String uploadMessage = null;
        try {
            uploadMessage = qnyConfig.upload(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(uploadMessage == null){
            return "文件上传失败，请检查网络状况";
        }
        //判断是否是福利图片
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Pic pic = null;
        if(!yy){
            pic = new Pic(0,name,timestamp,suffix,uploadMessage,"com");
        }else
        {
            pic = new Pic(0,name,timestamp,suffix,uploadMessage,"yy");
        }
        picMapper.addPic(pic);
        return "上传成功！";
    }

}
