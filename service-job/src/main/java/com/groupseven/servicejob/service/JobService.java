package com.groupseven.servicejob.service;

import com.groupseven.pojo.dto.JobDto;

import java.util.List;

public interface JobService {

    List<JobDto> getJobListByEid(Integer eid);
}
