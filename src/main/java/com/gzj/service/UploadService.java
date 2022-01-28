package com.gzj.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    /**
     *              文件上传
     * @param file  从前端获取的文件对象
     * @param yy    是否是福利图片
     * @return      返回图片url
     */
    String upload_file(MultipartFile file,boolean yy);


}
