package com.groupseven.serviceresume.controller;


import com.groupseven.serviceresume.Service.ResumeService;
import com.groupseven.serviceresume.pojo.DTO.EduDTO;
import com.groupseven.serviceresume.pojo.DTO.QueryDTO;
import com.groupseven.serviceresume.pojo.DTO.ResumeDTO;
import com.groupseven.serviceresume.pojo.DTO.WorkDTO;
import com.groupseven.serviceresume.pojo.VO.ResumeListVO;
import com.groupseven.serviceresume.pojo.VO.ResumeViewVO;
import com.groupseven.serviceresume.pojo.entity.Resume;
import lombok.extern.slf4j.Slf4j;
import com.groupseven.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("resume")
public class ResumeController {
    @Autowired
    private ResumeService resumeService;
    @PostMapping("add1")
    public Result<Void> add1(@RequestHeader("id") String id, @RequestBody Resume resume) {
        log.debug("id:{}", id);
        log.debug("resume:{}", resume);
        return Result.success();
    }
    @PostMapping("del")
    public Result del(@RequestHeader("id") String userid, @RequestBody  QueryDTO queryDTO ) {
        try {
            resumeService.del(userid, queryDTO.getResumeid());
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
        return Result.success();
    }
    @PostMapping("def")
    public Result def(@RequestHeader("id") String userid ,@RequestBody  QueryDTO queryDTO) {
        try {
            resumeService.def(userid,queryDTO.getResumeid());
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
        return Result.success();
    }
    @PostMapping("list")
    public Result list(@RequestHeader("id") String userid) {
        System.out.println(userid);
        List<ResumeListVO> list=resumeService.list(userid);
        return Result.success(list);
    }
   @PostMapping("view")
   public Result view(@RequestBody QueryDTO queryDTO) {
        ResumeViewVO resume =null;
        try {
            resume =resumeService.view(queryDTO.getResumeid());
            System.out.println(resume);
        }catch (Exception e){
            return Result.error(e.getMessage());
        }
        return Result.success(resume);
    }

    @PostMapping("addedu")
    public Result addedu(@RequestHeader("id") String userid ,@RequestBody EduDTO eduDTO) {
        try {
            resumeService.addedu(userid,eduDTO);
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
        return Result.success();
    }
    @PostMapping("addwork")
    public Result addwork(@RequestHeader("id") String userid ,@RequestBody WorkDTO workDTO) {
        try {
            resumeService.addwork(userid, workDTO);
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
        return Result.success();
    }
    @PostMapping("addresume")
    public Result addresume(@RequestHeader("id") String userid, @RequestBody ResumeDTO resume) {
        int id=resumeService.addresume(userid,resume);
        return Result.success(id);
    }

    @PostMapping("refresh")
    public Result refresh(@RequestBody QueryDTO queryDTO) {
        try {
            resumeService.refresh(queryDTO.getResumeid());
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
        return Result.success();
    }


}
