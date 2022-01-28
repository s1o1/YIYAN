package com.gzj.service.impl;

import com.gzj.dao.mapper.PicMapper;
import com.gzj.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    private PicMapper picMapper;
    @Override
    public Map<String,Object> getPics(int index) {
        //判断index是否合法
        if(index<=0){
            index = 1;
        }
        int maxIndex = picMapper.getPicNums("com")/6+1;
        if(index>maxIndex){
            index = maxIndex;
        }
        //默认查询6条记录
        int length = 6;
        Map<String,Object> map = new HashMap<>();
        map.put("pics",picMapper.getPic((index-1)*length,length,"com"));
        map.put("index",index);
        return map;
    }
}
