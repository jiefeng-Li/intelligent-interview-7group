package com.groupseven.servicejob.service.impl;


import com.groupseven.servicejob.entity.JobFavor;
import com.groupseven.servicejob.service.JobFavorService;
import com.groupseven.servicejob.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobFavorServiceImpl implements JobFavorService {

    @Autowired
    private JobService jobService;

    @Override
    public void add(JobFavor jobFavor) {
    }
}
