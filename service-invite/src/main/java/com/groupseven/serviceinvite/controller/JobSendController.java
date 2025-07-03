package com.groupseven.serviceinvite.controller;

import com.groupseven.common.Result;
import com.groupseven.serviceinvite.pojo.dto.JobSendDto;
import com.groupseven.pojo.dto.ResumeDto;
import com.groupseven.serviceinvite.forienClient.ResumeClient;
import com.groupseven.serviceinvite.service.JobSendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * test completed
 */
@RestController
@Slf4j
public class JobSendController {
    @Autowired
    private JobSendService jobSendService;
    @Autowired
    private ResumeClient resumeClient;

    /**
     * 投递简历
     * @param id 用户id
     * @param jobSendDto 投递信息
     * @return 是否成功
     *
     * 如果查询出已经存在投递的简历，就返回失败
     */
    @PostMapping("/jobsend")
    public Result jobsend(@RequestHeader String id, JobSendDto jobSendDto) {
        log.debug("用户id {}, 投递简历: {}", id, jobSendDto);
        boolean success = jobSendService.jobSend(id, jobSendDto);
        if (!success)
            return Result.error(401, "投递失败，你投递过简历");
        return Result.success("投递成功");
    }

    /**
     * 获取用户查看投递的职位
     * @return 投递记录
     */
    @PostMapping("/getInvite")
    public Result getInviteRecords(@RequestHeader String id) {
        System.out.println("user id is : " + id + " ______service_invite__________");
        Result<List<ResumeDto>> resumeByUserId = resumeClient.getResumeByUserId(Integer.parseInt(id));
        List<Integer> resumeIds = resumeByUserId.getData()
                .stream()
                .map(ResumeDto::getId)
                .toList();
        List<JobSendDto> res = jobSendService.getJobSEndByResumeIds(resumeIds);
        return Result.success(res);
    }


    /**
     * 删除收到的简历
     */
    @PostMapping("/deleteResumeByResumeId")
    public Result deleteResumeById(Integer remId) {
        jobSendService.deleteJobSendByResumeId(remId);
        return Result.success("删除成功");
    }
}
