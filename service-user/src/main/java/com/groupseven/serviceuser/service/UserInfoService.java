package com.groupseven.serviceuser.service;

import com.groupseven.serviceuser.pojo.entity.UserInfo;

public interface UserInfoService {
    UserInfo getUserInfoById(int id);
    void updateUserInfo(UserInfo userInfo);
} 