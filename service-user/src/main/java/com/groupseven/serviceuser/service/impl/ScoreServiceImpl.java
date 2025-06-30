package com.groupseven.serviceuser.service.impl;

import com.groupseven.serviceuser.mapper.ScoreMapper;
import com.groupseven.serviceuser.pojo.entity.Score;
import com.groupseven.serviceuser.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    public void add(Score score) {
        scoreMapper.insert(score);
    }
}