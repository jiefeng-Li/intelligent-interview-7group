package com.groupseven.servicejob.controller;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.groupseven.common.Result;
import com.groupseven.pojo.dto.JobDto;
import com.groupseven.pojo.vo.JobVO;
import com.groupseven.servicejob.entity.Job;
import com.groupseven.servicejob.exception.JobExistException;
import com.groupseven.servicejob.service.JobFavorService;
import com.groupseven.servicejob.service.JobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
public class JobController {

    @Autowired
    private JobService jobService;

    @Autowired
    private JobFavorService jobFavorService;

    @GetMapping("getJobListByEntId")
    public Result<List<JobDto>> getJobListByEntId(@RequestParam Integer entId) {
        log.info("getJobListByEntId: entId = {}", entId);
        return Result.success(jobService.getJobListByEid(entId));
    }

    @PostMapping("/getjobinfo")
    public Result<JobVO> getJobInfo(@RequestParam int id) {
        Job job = jobService.selectById(id);
        JobVO jobVO = new JobVO();
        BeanUtils.copyProperties(job, jobVO);
        return Result.success(jobVO);
    }

    @PostMapping("/addJob")
    public Result<Void> addJob(@RequestHeader("token") String token, @RequestBody JobDto AddJob) {
        final JWT jwt = JWTUtil.parseToken(token);
        String entId = jwt.getPayload("id").toString();
        try {
            jobService.add(Integer.parseInt(entId), AddJob.getName(),AddJob.getIndustry(),AddJob.getDescription(),AddJob.getMinWage(),AddJob.getMaxWage(),AddJob.getNum(),AddJob.getWelfare());
        } catch (JobExistException e) {
            e.printStackTrace();
            return Result.error(202, "AddJob Exist");
        }
        return Result.success();
    }

    @PostMapping("/deleteJob")
    public Result<Void> delete(@RequestParam int id) {
        try {
            jobService.delete(id);
        } catch (JobExistException e) {
            e.printStackTrace();
            return Result.error(202, "DeleteJob Exist");
        }
        return Result.success();
    }

    @PostMapping("/getList")
    public Result<List<JobVO>> selectJob() {
        return Result.success(jobService.selectJob());
    }

    @PostMapping("/getJobList")
    public Result<List<JobVO>> getJobList(@RequestHeader("token") String token) {
        final JWT jwt = JWTUtil.parseToken(token);
        String entId = jwt.getPayload("id").toString();
        return Result.success(jobService.selectJobList(Integer.parseInt(entId)));
    }

    @PostMapping("/selectJob")
    public Result<Job> selectById(@RequestParam int id) {
        return Result.success(jobService.selectById(id));
    }

    @PostMapping("/getJob")
    public Result<JobDto> getJob(@RequestParam int id) {
        return Result.success(jobService.getJob(id));
    }

    @PostMapping("/selectAllJobIds")
    public Result<List<Integer>> selectAllJobIds(@RequestParam int entId) {
        return Result.success(jobService.getAllJobIds(entId));
    }

    @PostMapping("/updateJob")
    public Result<Void> update(@RequestHeader("id") int id,@RequestHeader("token") String token,@RequestBody JobDto AddJob) {
        final JWT jwt = JWTUtil.parseToken(token);
        String entId = jwt.getPayload("id").toString();
        try {
            jobService.update(id,Integer.parseInt(entId), AddJob.getName(),AddJob.getIndustry(),AddJob.getDescription(),AddJob.getMinWage(),AddJob.getMaxWage(),AddJob.getNum(),AddJob.getWelfare());
        } catch (JobExistException e) {
            e.printStackTrace();
            return Result.error(202, "AddJob Exist");
        }
        return Result.success();
    }

}
