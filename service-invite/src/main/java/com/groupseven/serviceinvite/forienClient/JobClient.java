package com.groupseven.serviceinvite.forienClient;


import com.groupseven.common.Result;
import com.groupseven.pojo.dto.JobDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("service-job")
public interface JobClient {

    @GetMapping("getJobListByEntId")
    Result<List<JobDto>> getJobListByEntId(@RequestParam Integer entId);
}
