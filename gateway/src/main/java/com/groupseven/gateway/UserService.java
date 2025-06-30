package com.groupseven.gateway;

import com.groupseven.common.Result;
import com.groupseven.pojo.vo.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service-user")
public interface UserService {
    @GetMapping("verifyjwt")
    Result<Void> verifyJwt(@RequestParam String token);

    // 需要使用参数的注解@RequestParam表达发送的是get请求
    @GetMapping("parsejwt")
    Result<UserVo> parseJWT(@RequestParam String token);
}

