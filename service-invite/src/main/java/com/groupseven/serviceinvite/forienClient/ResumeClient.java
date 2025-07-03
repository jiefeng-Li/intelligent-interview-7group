package com.groupseven.serviceinvite.forienClient;


import com.groupseven.common.Result;
import com.groupseven.pojo.dto.ResumeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("service-resume")
public interface ResumeClient {
    @PostMapping("/getResumeByJobSends")
    Result<List<ResumeDto>> getResumeByJobSends(@RequestBody List<Integer> resumeIds);

    @GetMapping("/getResumeByUserId")
    Result<List<ResumeDto>> getResumeByUserId(@RequestParam Integer id);

    @GetMapping("/health")
    String health();

    @GetMapping("/getResumeById")
    Result<ResumeDto> getResumeById(@RequestParam Integer resumeId);
}
