package com.groupseven.serviceuser.service;

import com.groupseven.serviceuser.pojo.entity.Follow;
import java.util.List;

public interface FollowService {
    void follow(int userId, int entId);
    void unfollow(int userId, int entId);
    List<Follow> getFollowList(int userId);
    int getFollowCount(int userId);
} 