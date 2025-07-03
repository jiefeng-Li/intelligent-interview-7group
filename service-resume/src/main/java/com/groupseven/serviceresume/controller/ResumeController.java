package com.groupseven.serviceresume.controller;


import com.groupseven.pojo.dto.ResumeDto;
import com.groupseven.serviceresume.pojo.entity.Resume;
import com.groupseven.serviceresume.service.ResumeService;
import lombok.extern.slf4j.Slf4j;
import com.groupseven.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户简历控制类
 */
@Slf4j
@RestController
public class ResumeController {

    @Autowired
    private ResumeService resumeService;
    @PostMapping("add1")
    public Result<Void> add1(@RequestHeader("id") String id, @RequestBody Resume resume) {
        log.debug("id:{}", id);
        log.debug("resume:{}", resume);
        return Result.success();
    }


    /**
     * @author jiefeng-li
     * 获取投递到企业的简历
     *
     * service-invite调用service-resume的接口，根据职位投递id获取简历
     */
    @PostMapping("getResumeByJobSends")
    public Result<List<ResumeDto>> getResumeByJobSends(@RequestBody List<Integer> resumeIds) {
        return Result.success(resumeService.getResumeByJobSends(resumeIds));
    }

    @GetMapping("/getResumeByUserId")
    public Result<List<ResumeDto>> getResumeByUserId(@RequestParam Integer id) {
        System.out.println("\n\n\nuser id is : " + id + " _________________________\n\n\n");
        return Result.success(resumeService.getResumeByUserId(id));
    }

    @GetMapping("/getResumeById")
    public Result<ResumeDto> getResumeById(@RequestParam Integer resumeId) {
        return Result.success(resumeService.getResumeById(resumeId));
    }

    @GetMapping("/health")
    public String health() {
        return "service-resume is ok";
    }
}
