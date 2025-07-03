package com.groupseven.serviceuser.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.groupseven.pojo.dto.EnterpriseDto;
import com.groupseven.pojo.dto.FollowDto;
import com.groupseven.serviceuser.mapper.EnterpriseMapper;
import com.groupseven.serviceuser.mapper.FollowMapper;
import com.groupseven.serviceuser.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    @Autowired
    private EnterpriseMapper enterpriseMapper;

    @Autowired
    private FollowMapper followMapper;

    @Override
    @Transactional
    public EnterpriseDto getEnterpriseByUserId(Integer id) {
        System.out.println("method getEnterpriseByUserId: id" + id);
        FollowDto followDto = followMapper.selectOne(Wrappers.lambdaQuery(FollowDto.class).eq(FollowDto::getUserId, id));
        return enterpriseMapper.selectOne(Wrappers.lambdaQuery(EnterpriseDto.class)
                .eq(EnterpriseDto::getId, followDto.getEntId())
                .eq(EnterpriseDto::getIsDeleted, 0));
    }
}
