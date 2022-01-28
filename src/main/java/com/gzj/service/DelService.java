package com.gzj.service;

import org.apache.ibatis.annotations.Select;

public interface DelService {
    /**
     *                   通过图片名字删除图片
     * @param filename   图片名字
     * @return           删除信息
     */
    String delFile(String filename);
}
