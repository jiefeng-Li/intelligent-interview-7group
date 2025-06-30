package com.groupseven.servicebase.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.groupseven.servicebase.mapper.IndustryMapper;
import com.groupseven.servicebase.pojo.entity.Industry;
import com.groupseven.servicebase.service.IndustryService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndustryServiceImpl implements IndustryService {

    @Resource
    private IndustryMapper industryMapper;
    @Override
    public Industry getIndustryById(Integer id) {
        return null;
    }

    @Override
    public List<Industry> getAllIndustries() {
        return industryMapper.selectList(Wrappers.emptyWrapper());
    }
}
