package com.groupseven.serviceinvite.controller;

import com.groupseven.common.Result;
import com.groupseven.pojo.dto.ResumeDto;
import com.groupseven.serviceinvite.forienClient.ResumeClient;
import com.groupseven.serviceinvite.pojo.dto.InviteDto;
import com.groupseven.serviceinvite.service.InviteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 用户面试控制类
 */
@RestController
@Slf4j
public class UserInviteController {

    @Autowired
    private InviteService inviteService;
    @Autowired
    private ResumeClient resumeClient;

    /**
     * 查看面试通知
     */
    @PostMapping("/user/invite")
    public Result<List<InviteDto>> getInvite(@RequestHeader String id) {
        Result<List<ResumeDto>> resumeByUserId =
                resumeClient.getResumeByUserId(Integer.parseInt(id));
        List<Integer> rsmIds = resumeByUserId.getData()
                .stream().map(ResumeDto::getId).toList();
        List<InviteDto> inviteByRsmIds = inviteService.getInviteByRsmIds(rsmIds);
        return Result.success(inviteByRsmIds);
    }

    /**
     * 对面试通知答复
     *
     * 用户回复类型由前端传输
     * 类型见InviteStatus.reply
     *
     */
    @PostMapping("/user/inviteReply")
    public Result replyInvite(InviteDto inviteDto) {
        inviteService.replyInvite(inviteDto);
        return Result.success();
    }
}
