package com.groupseven.serviceuser.service;

import com.groupseven.serviceuser.pojo.dto.LoginUser;
import com.groupseven.serviceuser.pojo.entity.User;

public interface UserService {
    boolean register(String account,String password);

    User login(LoginUser user);

    User getById(Integer id);

    void updateAvatar(String avatar, Integer id);

    void setUserType(int id, String type);
}
