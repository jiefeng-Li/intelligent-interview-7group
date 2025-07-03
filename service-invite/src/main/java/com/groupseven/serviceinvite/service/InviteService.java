package com.groupseven.serviceinvite.service;

import com.groupseven.serviceinvite.pojo.dto.InviteDto;

import java.util.List;

public interface InviteService {

    void sendInvite(InviteDto inviteDto);

    List<InviteDto> getInviteByRsmIds(List<Integer> rsmIds);

    void replyInvite(InviteDto inviteDto);

    InviteDto getInvite(Integer rsmId, Integer jobId);
}
