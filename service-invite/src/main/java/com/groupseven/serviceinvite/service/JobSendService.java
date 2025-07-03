package com.groupseven.serviceinvite.service;

import com.groupseven.serviceinvite.pojo.dto.JobSendDto;

import java.util.List;

public interface JobSendService {

    boolean jobSend(String id, JobSendDto jobSendDto);


    List<JobSendDto> getJobSendRecordsByJobIds(List<Integer> jobIds);

    void deleteJobSendByResumeId(Integer remId);

    List<JobSendDto> getJobSEndByResumeIds(List<Integer> resumeIds);
}
