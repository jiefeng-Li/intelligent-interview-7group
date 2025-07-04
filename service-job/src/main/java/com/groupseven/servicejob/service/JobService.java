package com.groupseven.servicejob.service;

import com.groupseven.pojo.dto.JobDto;
import com.groupseven.pojo.vo.JobVO;
import com.groupseven.servicejob.entity.Job;

import java.util.List;

public interface JobService {

    List<JobDto> getJobListByEid(Integer eid);

    void add(int entId,String name,String industry,String description,int minWage,int maxWage,int num,String welfare);

    void delete(int id);

    List<JobVO> selectJob();

    List<JobVO> selectJobList(int entId);

    Job selectById(int id);

    JobDto getJob(int id);

    List<Integer> getAllJobIds(int id);

    void update(int id,int entId,String name,String industry,String description,int minWage,int maxWage,int num,String welfare);
}
