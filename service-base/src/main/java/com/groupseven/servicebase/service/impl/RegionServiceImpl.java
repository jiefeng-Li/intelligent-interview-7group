package com.groupseven.servicebase.service.impl;

import com.groupseven.servicebase.mapper.RegionMapper;
import com.groupseven.servicebase.pojo.entity.Region;
import com.groupseven.servicebase.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionMapper regionMapper;
    @Override
    public Region getById(Integer id) {
        Region region = regionMapper.selectById(id);
        return region;
    }

    @Override
    public List<Region> all() {

        return regionMapper.selectList(null);
    }
}
