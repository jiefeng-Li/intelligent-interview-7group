package com.groupseven.serviceuser.controller;

import com.groupseven.serviceuser.exception.ExceptionType;
import com.groupseven.serviceuser.pojo.entity.User;
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


    @PostMapping("/getuserinfo")
    public Result<UserInfoVo> getUserInfo(@RequestHeader int id) {
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

    @PostMapping("setusertype/{type}")
    public Result<Void> setUserType(@RequestHeader int id, @PathVariable String type) {
        userService.setUserType(id, type);
        return Result.success();
    }


    @GetMapping("/health")
    public String health() {
        return "ok";
    }
}
