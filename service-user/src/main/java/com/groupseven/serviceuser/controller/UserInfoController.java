package com.groupseven.serviceuser.controller;

import com.groupseven.serviceuser.exception.ExceptionType;
import com.groupseven.serviceuser.pojo.entity.User;
import com.groupseven.serviceuser.pojo.entity.UserInfo;
import com.groupseven.serviceuser.service.UserInfoService;
import com.groupseven.serviceuser.service.UserService;
import lombok.extern.slf4j.Slf4j;
import com.groupseven.common.Result;
import com.groupseven.pojo.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class UserInfoController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserInfoService userInfoService;


    @PostMapping("/getuserinfo")
    public Result<UserInfoVo> getUserInfo4InviteClinet(@RequestHeader int id) {
        log.debug("id:{}", id);
        User user = userService.getById(id);
        if (user == null)
            return Result.error(ExceptionType.USER_NOT_FOUND.getCode(),
                    ExceptionType.USER_NOT_FOUND.getMsg());
        UserInfoVo userInfoVO = new UserInfoVo();
        userInfoVO.setAccount(user.getAccount());
        userInfoVO.setAvatar(user.getAvatar());
        return Result.success(userInfoVO);
    }

    @PostMapping("/setusertype/{type}")
    public Result<Void> setUserType4Reg(@RequestHeader int id, @PathVariable String type) {
        userService.setUserType(id, type);
        return Result.success();
    }

    // 获取简要用户信息
    @GetMapping("/user/info/vo")
    public Result<UserInfoVo> getUserInfoVo(@RequestHeader int id) {
        log.debug("id:{}", id);
        User user = userService.getById(id);
        if (user == null)
            return Result.error(ExceptionType.USER_NOT_FOUND.getCode(),
                    ExceptionType.USER_NOT_FOUND.getMsg());
        UserInfoVo userInfoVO = new UserInfoVo();
        userInfoVO.setAccount(user.getAccount());
        userInfoVO.setAvatar(user.getAvatar());
        return Result.success(userInfoVO);
    }

    // 设置用户类型
    @PutMapping("/user/info/type/{type}")
    public Result<Void> setUserType(@RequestHeader int id, @PathVariable String type) {
        userService.setUserType(id, type);
        return Result.success();
    }

    // 获取详细用户信息
    @GetMapping("/user/info/")
    public Result<UserInfo> getUserInfo(@RequestHeader int id) {
        UserInfo userInfo = userInfoService.getUserInfoById(id);
        if (userInfo == null) {
            return Result.error(404, "未找到用户信息");
        }
        return Result.success(userInfo);
    }

    // 更新用户信息
    @PutMapping("/user/info/")
    public Result<Void> updateUserInfo(@RequestBody UserInfo userInfo) {
        userInfoService.updateUserInfo(userInfo);
        return Result.success();
    }


    @GetMapping("/health")
    public String health() {
        return "ok";
    }
}
