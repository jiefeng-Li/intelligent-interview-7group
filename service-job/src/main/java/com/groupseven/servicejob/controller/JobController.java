package com.groupseven.servicejob.controller;

import com.groupseven.common.Result;
import com.groupseven.pojo.dto.JobDto;
import com.groupseven.servicejob.service.JobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Slf4j
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("getJobListByEntId")
    public Result<List<JobDto>> getJobListByEntId(@RequestParam Integer entId) {
        log.info("getJobListByEntId: entId = {}", entId);
        return Result.success(jobService.getJobListByEid(entId));
    }

}
