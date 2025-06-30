package com.groupseven.portal.controller;

import com.groupseven.common.Result;
import com.groupseven.portal.controller.common.AliOSSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class UploadController {

    @Autowired
    private AliOSSUtil aliOSSUtil;

    @PostMapping("upload")
    public Result<String> upload(MultipartFile file) throws IOException {
        String url = aliOSSUtil.uploadFile(file);
        return Result.success("上传成功", url);
    }
}
