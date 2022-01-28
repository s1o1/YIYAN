package com.gzj.service.impl;

import com.gzj.config.QNYConfig;
import com.gzj.dao.mapper.PicMapper;
import com.gzj.service.DelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DelServiceImpl implements DelService {
    @Autowired
    private PicMapper picMapper;
    @Autowired
    private QNYConfig qnyConfig;
    @Override
    public String delFile(String filename) {
        if(filename==null || filename.length()==0){
            return "请填写要删除的文件名";
        }
        String url = picMapper.queryUrlByName(filename);
        if(url == null || url.length() ==0){
            return "此文件不存在";
        }
        picMapper.delPicByName(filename);
        String qnyHash = url.split(".com/")[1];
        qnyConfig.delete(qnyHash);
        return "删除成功";
    }
}
