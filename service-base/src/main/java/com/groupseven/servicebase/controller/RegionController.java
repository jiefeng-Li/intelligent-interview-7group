package com.groupseven.servicebase.controller;


import com.groupseven.servicebase.pojo.entity.Region;
import com.groupseven.servicebase.service.RegionService;
import com.groupseven.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/region")
@Slf4j
public class RegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping("{id}")
    public Result getRegionById(@PathVariable Integer id) {
        Region region = regionService.getById(id);
        log.debug("region:{}", region.getName());
        return Result.success(region);
    }
}
