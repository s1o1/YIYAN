package com.gzj.config;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import java.io.ByteArrayInputStream;

/**
 * 七牛云配置类
 */
@Data
@Component
@ConfigurationProperties(prefix = "qiniu")
public class QNYConfig {
    private  String accessKey;
    private  String secretKey;
    private  String bucket;
    private String url;
    public String upload(byte[] uploadBytes){
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.region2());

        UploadManager uploadManager = new UploadManager(cfg);
        //生成上传凭证，然后准备上传

        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = null;
        ByteArrayInputStream byteInputStream=new ByteArrayInputStream(uploadBytes);
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);

        DefaultPutRet putRet = null;
        try {
            Response response = uploadManager.put(byteInputStream,key,upToken,null, null);
            //解析上传成功的结果
            putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        if(putRet!=null){
            return url+putRet.hash;
        }
        return null;

    }
    public void delete(String fileName){
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.region2());
        Auth auth = Auth.create(accessKey, secretKey);
        BucketManager bucketManager = new BucketManager(auth, cfg);
        try {
            bucketManager.delete(bucket,fileName);
        } catch (QiniuException e) {
            e.printStackTrace();
        }
    }
}

