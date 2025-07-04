package com.groupseven.serviceuser.service;

import com.groupseven.pojo.dto.EnterpriseDto;
import com.groupseven.serviceuser.pojo.entity.Enterprise;

public interface EnterpriseService {
    EnterpriseDto getEnterpriseByUserId(Integer id);
    void updateEnterprise(Enterprise enterprise);

    Enterprise getEnterpriseByUserId(int userId);
}
