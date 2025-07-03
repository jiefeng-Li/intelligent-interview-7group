package com.groupseven.servicebase.service;

import com.groupseven.servicebase.pojo.entity.Region;

import java.util.List;

public interface RegionService {
    Region getById(Integer id);

    List<Region> all();
}
