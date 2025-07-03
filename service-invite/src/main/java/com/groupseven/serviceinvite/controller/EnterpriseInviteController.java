package com.groupseven.serviceinvite.controller;


import com.groupseven.common.Result;
import com.groupseven.pojo.dto.EnterpriseDto;
import com.groupseven.pojo.dto.JobDto;
import com.groupseven.pojo.dto.ResumeDto;
import com.groupseven.pojo.vo.UserInfoVo;
import com.groupseven.serviceinvite.forienClient.JobClient;
import com.groupseven.serviceinvite.forienClient.ResumeClient;
import com.groupseven.serviceinvite.forienClient.UserClient;
import com.groupseven.serviceinvite.pojo.dto.InviteDto;
import com.groupseven.serviceinvite.pojo.dto.JobSendDto;
import com.groupseven.serviceinvite.pojo.vo.ResumeVo;
import com.groupseven.serviceinvite.service.InviteService;
import com.groupseven.serviceinvite.service.JobSendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 公司面试控制类
 */

@RestController
@Slf4j
public class EnterpriseInviteController {

    @Autowired
    private InviteService inviteService;

    @Autowired
    private JobSendService jobSendService;

    @Autowired
    private UserClient userClient;
    @Autowired
    private JobClient jobClient;
    @Autowired
    private ResumeClient resumeClient;


    @GetMapping("/clientTest")
    public String clientTest(){
        return resumeClient.health();
    }



    /**
     * 获取投递到企业的简历
     * 通过useriid获取到公司id，(dbuser)				    1 --> 1
     * 通过公司id获取到职位id，(dbjob)->qlmjob			    1 --> n
     * 通过职位id获取到简历id（dbinvite）->qlm_job_send 	1 --> n
     * 简历id获取简历  									1 --> 1
     *
     */
    @PostMapping("/getResumeByEnt")
    public Result<List<ResumeVo>> getResumeByEnt(@RequestHeader String id) {
        Result<EnterpriseDto> r1 = userClient.getEnterpriseByUserId(Integer.parseInt(id));
        Result<List<JobDto>> r2 = jobClient.getJobListByEntId(r1.getData().getId());// 使用企业ID调用getJobListByEntId方法
        List<Integer> jobIds = r2.getData().stream().map(JobDto::getId).toList();
        List<JobSendDto> jobSend = jobSendService.getJobSendRecordsByJobIds(jobIds);
        List<ResumeVo> resumeVoList = new ArrayList<>();
        for (JobSendDto j : jobSend) {
            ResumeVo resumeVo = new ResumeVo();
            resumeVo.setJobSendDto(j);
            for (JobDto rjob : r2.getData()) {
                if (rjob.getId().equals(j.getJobId()))
                    resumeVo.setJobDto(rjob);
            }
            ResumeDto rem = resumeClient.getResumeById(j.getResumeId()).getData();
            Result<UserInfoVo> userInfo = userClient.getUserInfo(id);
            resumeVo.setAvatar(userInfo.getData().getAvatar());
            resumeVo.setResumeDto(rem);
            resumeVo.setInviteDto(inviteService.getInvite(j.getResumeId(), j.getJobId()));
            resumeVoList.add(resumeVo);
        }
        return Result.success(resumeVoList);
    }

    /**
     * 判断求职者是否满足职位要求
     */
    @PostMapping("/judgeResume")
    public Result judgeResume(@RequestHeader String id, JobSendDto jobSendDto) {
        //TODO 判断求职者是否满足职位要求
        return Result.success();
    }

    /**
     * 邀约面试
     */
    @PostMapping("/sendInvite")
    public Result invite(@RequestBody InviteDto inviteDto){
        inviteService.sendInvite(inviteDto);
        return Result.success();
    }
}
