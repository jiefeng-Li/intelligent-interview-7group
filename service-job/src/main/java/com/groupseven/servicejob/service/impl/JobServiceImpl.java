package com.groupseven.servicejob.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.groupseven.pojo.dto.JobDto;
import com.groupseven.servicejob.mapper.JobMapper;
import com.groupseven.servicejob.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobMapper jobMapper;

    @Override
    public List<JobDto> getJobListByEid(Integer eid) {
        return jobMapper.selectList(Wrappers.lambdaQuery(JobDto.class)
                .eq(JobDto::getEntId, eid)
                .eq(JobDto::getIsDeleted, 0));
    }
}
