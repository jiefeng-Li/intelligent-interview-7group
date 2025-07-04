package com.groupseven.servicejob.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.groupseven.servicejob.entity.Job;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface JobMapper extends BaseMapper<Job> {
    @Update("update qlm_job set is_deleted = 'y' where id = #{id}")
    void deleteJob(int id);

    @Select("select * from qlm_job where is_deleted = 'n'")
    List<Job> selectJob();

    @Select("select * from qlm_job where id = #{id} and is_deleted = 'n'")
    Job selectJobById(int id);

    @Select("select id from qlm_job where ent_id = #{entId}")
    List<Integer> getAllJobIds(int entId);

    @Select("select * from qlm_job where is_deleted = 'n' and ent_id = #{entId}")
    List<Job> selectJobList(int entId);
}
