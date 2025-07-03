package com.groupseven.serviceinvite.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.groupseven.serviceinvite.comon.JobSendStatus;
import com.groupseven.serviceinvite.mapper.JobSendMapper;
import com.groupseven.serviceinvite.pojo.dto.JobSendDto;
import com.groupseven.serviceinvite.service.JobSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JobSendServiceImpl implements JobSendService {

    @Autowired
    private JobSendMapper jobSendMapper;

    /**
     * 投递简历
     * @param id 用户id
     * @param jobSendDto 投递信息
     * @return 是否成功
     *
     * 如果查询出已经存在投递的简历，就返回失败
     */
    @Override
    @Transactional
    public boolean jobSend(String id, JobSendDto jobSendDto) {
//        jobSendDto.setId(Integer.parseInt(id));
        JobSendDto exist = jobSendMapper.selectOne(Wrappers.lambdaQuery(JobSendDto.class)
                .eq(JobSendDto::getResumeId, jobSendDto.getResumeId())
                .eq(JobSendDto::getJobId, jobSendDto.getJobId())
                .ne(JobSendDto::getStatus, JobSendStatus.status.DELETED));
        if (exist != null) {
            return false;
        }
        jobSendDto.setSendTime(LocalDateTime.now());
        jobSendDto.setViewed(JobSendStatus.viewed.NOT_VIEWED);
        jobSendDto.setStatus(JobSendStatus.status.NOT_PASS);
        jobSendMapper.insert(jobSendDto);
        return true;
    }

    @Override
    public List<JobSendDto> getJobSendRecordsByJobIds(List<Integer> jobIds) {
        List<JobSendDto> jobSendDtos = jobSendMapper.selectList(Wrappers.lambdaQuery(JobSendDto.class)
                .in(JobSendDto::getJobId, jobIds));
        return jobSendDtos;
    }

    @Override
    public void deleteJobSendByResumeId(Integer remId) {
        jobSendMapper.updateByResumeId(remId, JobSendStatus.status.DELETED);
    }

    @Override
    public List<JobSendDto> getJobSEndByResumeIds(List<Integer> resumeIds) {
        if (resumeIds == null || resumeIds.isEmpty()) {
            // 返回空列表或者根据业务需求返回null
            return null;
        }
        List<JobSendDto> rs = jobSendMapper.selectList(Wrappers.lambdaQuery(JobSendDto.class)
                .in(JobSendDto::getResumeId, resumeIds));
        return rs;
    }
}
