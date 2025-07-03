package com.groupseven.serviceinvite.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.groupseven.serviceinvite.pojo.dto.JobSendDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface JobSendMapper extends BaseMapper<JobSendDto> {

    @Update("update qlm_job_send set state = #{newState} where resume_id = #{remId}")
    void updateByResumeId(Integer remId, String newState);
}
