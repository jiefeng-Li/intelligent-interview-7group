package com.groupseven.serviceresume.controller;


import com.groupseven.serviceresume.pojo.entity.Resume;
import lombok.extern.slf4j.Slf4j;
import com.groupseven.common.Result;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("resume")
public class ResumeController {
    @PostMapping("add1")
    public Result<Void> add1(@RequestHeader("id") String id, @RequestBody Resume resume) {
        log.debug("id:{}", id);
        log.debug("resume:{}", resume);
        return Result.success();
    }
}
