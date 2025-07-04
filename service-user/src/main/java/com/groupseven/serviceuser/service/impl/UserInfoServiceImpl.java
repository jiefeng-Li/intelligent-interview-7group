package com.groupseven.serviceuser.service.impl;

import com.groupseven.serviceuser.mapper.UserInfoMapper;
import com.groupseven.serviceuser.pojo.entity.UserInfo;
import com.groupseven.serviceuser.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getUserInfoById(int id) {
        return userInfoMapper.selectById(id);
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        userInfoMapper.updateById(userInfo);
    }
} 