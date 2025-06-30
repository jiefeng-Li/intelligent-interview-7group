package com.groupseven.serviceuser.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.groupseven.serviceuser.mapper.ScoreMapper;
import com.groupseven.serviceuser.pojo.entity.Score;
import com.groupseven.serviceuser.pojo.dto.LoginUser;
import com.groupseven.serviceuser.pojo.entity.User;
import com.groupseven.serviceuser.mapper.UserMapper;
import com.groupseven.serviceuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    @Transactional
    public boolean register(String account, String password) {
        if (userMapper.selectOne(Wrappers.lambdaQuery(User.class)
                .eq(User::getAccount, account)) != null)
            return false;
        User user = User.builder()
                .account(account)
                .password(password)
                .regTime(LocalDateTime.now())
                .score(0)
                .status("1").build();
        userMapper.insert(user);
        return true;
    }

    @Override
    @Transactional
    public User login(LoginUser user) {
        User u = userMapper.selectOne(Wrappers.lambdaQuery(User.class)
                .eq(User::getAccount, user.getAccount()));
        if (u == null || !u.getPassword().equals(user.getPassword())) {
            return null;
        }
        //为该用户增加5个积分
        userMapper.updateScore(u.getId(), 5);
        //记录增加记录的明细
        Score score = new Score();
        score.setUserId(u.getId());
        score.setReason("成功登录");
        score.setRecordTime(LocalDateTime.now());
        score.setDelta(5);
        scoreMapper.insert(score);
        return u;
    }

    @Override
    public User getById(Integer id) {
        User user = userMapper.selectOne(Wrappers.lambdaQuery(User.class)
                .eq(User::getId, id));
        return user;
    }

    @Override
    public void updateAvatar(String avatar, Integer id) {
        userMapper.updateAvatarById(avatar, id);
    }

    @Override
    public void setUserType(int id, String type) {
        User user = User.builder()
                .id(id)
                .type(type).build();
        userMapper.updateById(user);
    }
}
