package com.groupseven.serviceinvite.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.groupseven.serviceinvite.comon.InviteStatus;
import com.groupseven.serviceinvite.mapper.InviteMapper;
import com.groupseven.serviceinvite.pojo.dto.InviteDto;
import com.groupseven.serviceinvite.service.InviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class InviteServiceImpl implements InviteService {

    @Autowired
    private InviteMapper inviteMapper;


    /**
     * 邀约面试
     * 通过职位投递信息来发送邀请
     * @param inviteDto
     */
    @Override
    @Transactional
    public void sendInvite(InviteDto inviteDto) {
        InviteDto sent = inviteMapper.selectOne(Wrappers.lambdaQuery(InviteDto.class)
                .eq(InviteDto::getResumeId, inviteDto.getResumeId())
                .eq(InviteDto::getJobId, inviteDto.getJobId())
                .eq(InviteDto::getReply, InviteStatus.reply.PENDING));
        //TODO 添加异常处理器
        if (sent != null) {
            throw new RuntimeException("该简历已发送邀请");
        }
        inviteDto.setReply(InviteStatus.reply.PENDING);
        inviteMapper.insert(inviteDto);
    }

    @Override
    public List<InviteDto> getInviteByRsmIds(List<Integer> rsmIds) {
        return inviteMapper.selectList(Wrappers.lambdaQuery(InviteDto.class)
                .in(InviteDto::getResumeId, rsmIds)
                .ne(InviteDto::getReply, InviteStatus.reply.ACCEPTED));
    }

    @Override
    public void replyInvite(InviteDto inviteDto) {
        inviteMapper.update(inviteDto,
                Wrappers.lambdaQuery(InviteDto.class)
                        .eq(InviteDto::getId, inviteDto.getId()));
    }

    @Override
    public InviteDto getInvite(Integer rsmId, Integer jobId) {
        return inviteMapper.selectOne(Wrappers.lambdaQuery(InviteDto.class)
                .eq(InviteDto::getResumeId, rsmId)
                .eq(InviteDto::getJobId, jobId));
    }

}
