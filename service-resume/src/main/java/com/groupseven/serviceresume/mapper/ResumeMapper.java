package com.groupseven.serviceresume.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.groupseven.serviceresume.pojo.entity.Resume;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ResumeMapper extends BaseMapper<Resume> {
}