package com.groupseven.serviceuser.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.groupseven.serviceuser.mapper.FollowMapper;
import com.groupseven.serviceuser.pojo.entity.Follow;
import com.groupseven.serviceuser.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FollowServiceImpl implements FollowService {
    @Autowired
    private FollowMapper followMapper;

    @Override
    public void follow(int userId, int entId) {
        Follow follow = new Follow();
        follow.setUserId(userId);
        follow.setEntId(entId);
        follow.setFollowTime(LocalDateTime.now());
        followMapper.insert(follow);
    }

    @Override
    public void unfollow(int userId, int entId) {
        QueryWrapper<Follow> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId).eq("ent_id", entId);
        followMapper.delete(wrapper);
    }

    @Override
    public List<Follow> getFollowList(int userId) {
        QueryWrapper<Follow> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        return followMapper.selectList(wrapper);
    }

    @Override
    public int getFollowCount(int userId) {
        QueryWrapper<Follow> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        return Math.toIntExact(followMapper.selectCount(wrapper));
    }
} 