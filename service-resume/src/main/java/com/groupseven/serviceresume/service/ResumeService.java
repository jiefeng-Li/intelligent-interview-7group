package com.groupseven.serviceresume.service;

import com.groupseven.pojo.dto.ResumeDto;

import java.util.List;

public interface ResumeService {
    List<ResumeDto> getResumeByJobSends(List<Integer> resumeIds);

    List<ResumeDto> getResumeByUserId(Integer id);

    ResumeDto getResumeById(Integer resumeId);
}
