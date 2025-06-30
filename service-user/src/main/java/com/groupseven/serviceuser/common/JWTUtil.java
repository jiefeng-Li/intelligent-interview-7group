package com.groupseven.serviceuser.common;

import cn.hutool.core.date.DateUtil;
import cn.hutool.jwt.JWT;
import com.groupseven.serviceuser.pojo.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class JWTUtil {

    @Value("${jwt.secretKey}")
    private static String JWT_SECRET_KEY;
    private static final int JWT_EXP_OFFSET = 15; // 获取当前时间并偏移15天

    public static String sign(User user){
            Date expireDate = DateUtil.offsetDay(DateUtil.date(), JWT_EXP_OFFSET);
            String sign = JWT.create()
                    .setPayload("id", user.getId())
                    .setPayload("account", user.getAccount())
                    .setExpiresAt(expireDate) // 设置JWT令牌的过期时间为偏移后的日期
                    .setKey(JWT_SECRET_KEY.getBytes())
                    .sign();
        return sign;
    }


    public static boolean verify(String token){
        return JWT.of(token).setKey(JWT_SECRET_KEY.getBytes()).verify();
    }
}
