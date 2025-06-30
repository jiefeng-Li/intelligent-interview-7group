package com.groupseven.servicebase.controller;


import com.groupseven.servicebase.pojo.entity.Industry;
import com.groupseven.servicebase.service.IndustryService;
import com.groupseven.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/industry")
public class IndustryController {
    @Autowired
    private IndustryService industryService;



    @GetMapping("/getAll")
    public Result<List<Industry>> getAllIndustries() {
        return Result.success(industryService.getAllIndustries());
    }
}
