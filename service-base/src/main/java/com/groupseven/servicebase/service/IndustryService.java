package com.groupseven.servicebase.service;

import com.groupseven.servicebase.pojo.entity.Industry;

import java.util.List;

public interface IndustryService {
    Industry getIndustryById(Integer id);

    List<Industry> getAllIndustries();
}
