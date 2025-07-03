package com.groupseven.servicebase.controller;


import com.groupseven.servicebase.pojo.entity.Region;
import com.groupseven.servicebase.service.RegionService;
import com.groupseven.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/region")

public class RegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping("{id}")
    public Result getRegionById(@PathVariable Integer id) {
        Region region = regionService.getById(id);
        return Result.success(region);
    }
    @PostMapping
    public Result Region() {
        List<Region> list= regionService.all();
        return Result.success(list);
    }
}
