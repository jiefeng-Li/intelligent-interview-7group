package com.groupseven.servicebase.controller;


import cn.hutool.cache.impl.TimedCache;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;

import lombok.extern.slf4j.Slf4j;
import com.groupseven.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
public class CaptchaController {

    @Autowired
    private TimedCache<String, String> timedCache;

    @PostMapping("captcha")
    public Result<String[]> createCaptcha() {
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(115, 35,4,16);
        String code = lineCaptcha.getCode();
        String uuid = UUID.randomUUID().toString();
        timedCache.put(uuid, code);  // 存储缓存到服务器内存中
        String imageBase64 = lineCaptcha.getImageBase64();
        log.debug("code:{},imageBase64:{}", code, imageBase64);
        return Result.success(new String[]{uuid, imageBase64});
    }



    record RegUser(String account, String password, String code, String uuid, String type) {}

    @PostMapping("checkcaptcha")
    public Result<Void> checkCaptcha(@RequestBody RegUser regUser) {
        log.debug("regUser:{}", regUser);
        if (timedCache.get(regUser.uuid()) == null) {
            return Result.error(301, "Cache Invalid");
        }
        if (regUser.code().equalsIgnoreCase(timedCache.get(regUser.uuid()))) {
            return Result.success();
        }
        return Result.error(301, "Cache Invalid");

    }
}
