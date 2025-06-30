package com.groupseven.portal.controller.common;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.groupseven.portal.controller.config.AliOSSConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;


@Component
public class AliOSSUtil {
    @Autowired
    private OSS ossClient;
    @Autowired
    private AliOSSConfig aliOSSConfig;

    public String uploadFile(MultipartFile file) throws IOException { {
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        String newFileName = UUID.randomUUID().toString().replace("-", "");
        //file.transferTo(new File("D://qlmimages//" + newFileName + suffix));
        //获取文件的后缀，产生以为不重复的名称
        //调用阿里云的SDK上传至OSS
        PutObjectRequest putObjectRequest = new PutObjectRequest(aliOSSConfig.getBucketName(), newFileName + suffix,
                file.getInputStream());
        // 上传文件。
        PutObjectResult result = ossClient.putObject(putObjectRequest);
        String url = "https://" + aliOSSConfig.getBucketName() + "." + aliOSSConfig.getEndpoint() + "/" + newFileName + suffix;
        return url;
    }}
}
