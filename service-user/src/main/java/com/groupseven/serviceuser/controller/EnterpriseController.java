package com.groupseven.serviceuser.controller;


import com.groupseven.common.Result;
import com.groupseven.pojo.dto.EnterpriseDto;
import com.groupseven.serviceuser.pojo.entity.Enterprise;
import com.groupseven.serviceuser.service.EnterpriseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    /**
     * 根据用户id获取企业信息
     * @param id 用户id
     * @return 企业信息
     * service-invite调用service-user的接口，根据用户id获取企业信息
     */
    @PostMapping("/getEnterpriseByUserId")
    public Result<EnterpriseDto> getEnterpriseByUserId(@RequestParam Integer id) {
        EnterpriseDto enterprise = enterpriseService.getEnterpriseByUserId(id);
        if (enterprise == null) {
            return Result.error("企业不存在");
        }
        return Result.success("成功", enterprise);
    }

    @GetMapping("/enterprise")
    public Result<Enterprise> getEnterprise(@RequestHeader int userId) {
        Enterprise enterprise = enterpriseService.getEnterpriseByUserId(userId);
        if (enterprise == null) {
            return Result.error(404, "未找到企业信息");
        }
        return Result.success(enterprise);
    }

    @PutMapping("/enterprise")
    public Result<Void> updateEnterprise(@RequestBody Enterprise enterprise) {
        enterpriseService.updateEnterprise(enterprise);
        return Result.success();
    }
}
