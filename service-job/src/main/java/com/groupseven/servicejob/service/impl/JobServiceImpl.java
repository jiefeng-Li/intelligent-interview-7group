package com.groupseven.servicejob.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.groupseven.pojo.dto.JobDto;
import com.groupseven.pojo.vo.JobVO;
import com.groupseven.servicejob.entity.Job;
import com.groupseven.servicejob.exception.JobExistException;
import com.groupseven.servicejob.mapper.JobMapper;
import com.groupseven.servicejob.mapper.JobMapper4Invite;
import com.groupseven.servicejob.service.JobService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobMapper4Invite jobMapper4Invite;

    @Autowired
    private JobMapper jobMapper;

    @Override
    public List<JobDto> getJobListByEid(Integer eid) {
        return jobMapper4Invite.selectList(Wrappers.lambdaQuery(JobDto.class)
                .eq(JobDto::getEntId, eid)
                .eq(JobDto::getIsDeleted, 0));
    }


    @Override
    public void add(int entId,String name,String industry,String description,int minWage,int maxWage,int num,String welfare){
        Job job = new Job();
        job.setEntId(entId);
        job.setName(name);
        job.setIndustry(industry);
        job.setDescription(description);
        job.setMinWage(minWage);
        job.setMaxWage(maxWage);
        job.setNum(num);
        job.setWelfare(welfare);
        job.setPubTime(LocalDateTime.now());
        job.setRefreshTime(LocalDateTime.now());
        job.setViewNum(0);
        job.setFavorNum(0);
        job.setDeliveNum(0);
        job.setStatus("y");
        job.setIsDeleted("n");
        LambdaQueryWrapper<Job> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Job::getEntId, entId)
                .eq(Job::getName, name);
        if (jobMapper.exists(wrapper)) {
            throw new JobExistException("该职位已存在");
        }
        jobMapper.insert(job);
    }

    @Override
    public void delete(int id){
        jobMapper.deleteJob(id);
    }

    @Override
    public List<JobVO> selectJob() {
        List<Job> jobList = jobMapper.selectJob();
        List<JobVO> jobVOList = new ArrayList<>();
        for (Job job : jobList) {
            JobVO jobVO = new JobVO();
            BeanUtils.copyProperties(job, jobVO);
            jobVOList.add(jobVO);
        }
        return jobVOList;
    }

    @Override
    public List<JobVO> selectJobList(int entId){
        List<Job> jobList = jobMapper.selectJobList(entId);
        List<JobVO> jobVOList = new ArrayList<>();
        for (Job job : jobList) {
            JobVO jobVO = new JobVO();
            BeanUtils.copyProperties(job, jobVO);
            jobVOList.add(jobVO);
        }
        return jobVOList;
    }

    @Override
    public Job selectById(int id){
        return jobMapper.selectJobById(id);
    }

    @Override
    public JobDto getJob(int id){
        Job job = jobMapper.selectJobById(id);
        JobDto jobDTO = new JobDto();
        BeanUtils.copyProperties(job,jobDTO);
        return jobDTO;
    }

    @Override
    public List<Integer> getAllJobIds(int id){
        return jobMapper.getAllJobIds(id);
    }

    @Override
    public void update(int id,int entId,String name,String industry,String description,int minWage,int maxWage,int num,String welfare){
        Job job = jobMapper.selectJobById(id);
        job.setEntId(entId);
        job.setName(name);
        job.setIndustry(industry);
        job.setIndustry(description);
        job.setMinWage(minWage);
        job.setMaxWage(maxWage);
        job.setNum(num);
        job.setWelfare(welfare);
        job.setRefreshTime(LocalDateTime.now());
        LambdaQueryWrapper<Job> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Job::getEntId, entId)
                .eq(Job::getName, name);
//        if (jobMapper.exists(wrapper)) {
//            throw new JobExistException("该职位已存在");
//        }
        LambdaUpdateWrapper<Job> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Job::getId, id);
        jobMapper.update(job,updateWrapper);
    }
}
