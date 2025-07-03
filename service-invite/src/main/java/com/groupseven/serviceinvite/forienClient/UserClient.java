package com.groupseven.serviceinvite.forienClient;


import com.groupseven.common.Result;
import com.groupseven.pojo.dto.EnterpriseDto;
import com.groupseven.pojo.vo.UserInfoVo;
import com.groupseven.pojo.vo.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service-user")
public interface UserClient {
    @PostMapping("getEnterpriseByUserId")
    Result<EnterpriseDto> getEnterpriseByUserId(@RequestParam Integer id);

    @GetMapping("/health")
    String health();

    @PostMapping("/getuserinfo")
    Result<UserInfoVo> getUserInfo(@RequestHeader String id);
}
