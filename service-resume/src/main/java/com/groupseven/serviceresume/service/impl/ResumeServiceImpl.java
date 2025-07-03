package com.groupseven.serviceresume.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.groupseven.pojo.dto.ResumeDto;
import com.groupseven.serviceresume.mapper.ResumeMapper;
import com.groupseven.serviceresume.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {
    @Autowired
    private ResumeMapper resumeMapper;

    private static final String DELETE = "1";
    private static final String NOT_DELETE = "0";

    @Override
    public List<ResumeDto> getResumeByJobSends(List<Integer> resumeIds) {
        //检查没被删除的，以及id在resumeIds中的
        return resumeMapper.selectList(Wrappers.lambdaQuery(ResumeDto.class)
                .eq(ResumeDto::getIsDeleted, NOT_DELETE)
                .in(ResumeDto::getId, resumeIds));
    }

    @Override
    public List<ResumeDto> getResumeByUserId(Integer id) {
        return resumeMapper.selectList(Wrappers.lambdaQuery(ResumeDto.class)
                .eq(ResumeDto::getIsDeleted, NOT_DELETE)
                .eq(ResumeDto::getUserId, id));
    }

    @Override
    public ResumeDto getResumeById(Integer resumeId) {
        return resumeMapper.selectById(resumeId);
    }
}
