package com.groupseven.servicejob.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.groupseven.pojo.dto.JobDto;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface JobMapper extends BaseMapper<JobDto> {
}
