package com.groupseven.serviceuser.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.groupseven.pojo.dto.EnterpriseDto;
import com.groupseven.pojo.dto.FollowDto;
import com.groupseven.serviceuser.mapper.EnterpriseMapper;
import com.groupseven.serviceuser.mapper.EnterpriseMapper4Invite;
import com.groupseven.serviceuser.mapper.FollowMapper;
import com.groupseven.serviceuser.mapper.FollowMapper4Invite;
import com.groupseven.serviceuser.pojo.entity.Enterprise;
import com.groupseven.serviceuser.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    @Autowired
    private EnterpriseMapper enterpriseMapper;

    @Autowired
    private EnterpriseMapper4Invite enterpriseMapper4Invite;

    @Autowired
    private FollowMapper4Invite followMapper4Invite;

    @Autowired
    private FollowMapper followMapper;

    @Override
    @Transactional
    public EnterpriseDto getEnterpriseByUserId(Integer id) {
        System.out.println("method getEnterpriseByUserId: id" + id);
        FollowDto followDto = followMapper4Invite.selectOne(Wrappers.lambdaQuery(FollowDto.class).eq(FollowDto::getUserId, id));
        return enterpriseMapper4Invite.selectOne(Wrappers.lambdaQuery(EnterpriseDto.class)
                .eq(EnterpriseDto::getId, followDto.getEntId())
                .eq(EnterpriseDto::getIsDeleted, 0));
    }
    @Override
    public void updateEnterprise(Enterprise enterprise) {
        enterpriseMapper.updateById(enterprise);
    }


    @Override
    public Enterprise getEnterpriseByUserId(int userId) {
        QueryWrapper<Enterprise> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        return enterpriseMapper.selectOne(wrapper);
    }
}
