package com.groupseven.serviceuser.service;

import com.groupseven.pojo.dto.EnterpriseDto;

public interface EnterpriseService {
    EnterpriseDto getEnterpriseByUserId(Integer id);
}
