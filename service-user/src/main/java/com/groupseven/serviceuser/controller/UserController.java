package com.groupseven.serviceuser.controller;


import cn.hutool.core.date.DateUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.groupseven.serviceuser.pojo.dto.LoginUser;
import com.groupseven.serviceuser.pojo.entity.User;
import com.groupseven.pojo.vo.UserVo;
import com.groupseven.serviceuser.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import com.groupseven.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@Slf4j
@RestController
public class UserController {

    @Value("${jwt.secretKey}")
    private String JWT_SECRET_KEY;
    @Autowired
    private UserService userService;




    @PostMapping("/login")
    public Result login(@RequestBody LoginUser loginUser, HttpServletResponse response) {
        log.debug("loginUser: {}", loginUser);
        User user = userService.login(loginUser);
        if (user == null) {
            return Result.error(400,"用户名或密码错误");
        }
        Date expireDate = DateUtil.offsetDay(DateUtil.date(), 15);
        String sign = JWT.create()
                .setPayload("id", user.getId())
                .setPayload("account", user.getAccount())
                .setExpiresAt(expireDate) // 设置JWT令牌的过期时间为偏移后的日期
                .setKey(JWT_SECRET_KEY.getBytes())
                .sign();
        response.addHeader("token", sign);
        return Result.success("success", user.getType());
    }

    @PostMapping("/reg")
    public Result register(@RequestBody LoginUser loginUser) {
        log.debug("register: {}", loginUser);
        boolean register = userService.register(loginUser.getAccount(), loginUser.getPassword());
        if (!register) {
            return Result.error(400,"注册失败");
        }
        return Result.success("注册成功");
    }

    @PostMapping("verifyjwt")
    public Result<Void> verifyJwt(@RequestHeader("token") String token) {
        log.debug("token:{}", token);
        boolean isValid = false;
        try {
            isValid = JWTUtil.verify(token, JWT_SECRET_KEY.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (isValid) {
            return Result.success();
        }
        return Result.error(400, "验证失败");
    }

    @GetMapping("verifyjwt")
    public Result<Void> verifyJwt2(@RequestParam String token) {
        log.debug("token:{}", token);
        boolean isValid = false;
        try {
            isValid = JWTUtil.verify(token, JWT_SECRET_KEY.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (isValid) {
            return Result.success("验证成功");
        }
        return Result.error(400, "验证失败");
    }

    @GetMapping("parsejwt")
    public Result<UserVo> parseJwt(String token) {
        final JWT jwt = cn.hutool.jwt.JWTUtil.parseToken(token);
        Object id = jwt.getPayload("id");
        System.out.println(id);

        UserVo userVO = new UserVo();
        userVO.setId(Integer.parseInt(id.toString()));
        userVO.setAccount(jwt.getPayload("account").toString());
//        userVO.setType();

        return new Result<UserVo>(200, "成功", userVO);
    }


    @GetMapping("updateAvatar")
    public Result updateUserAvatar(@RequestHeader("id") String id, String avatar) {
        log.debug("user id :{}, avatar user: {}", id, avatar);
        userService.updateAvatar(avatar, Integer.parseInt(id));
        return Result.success("头像更新成功");
    }
}
