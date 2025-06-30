package com.groupseven.serviceuser.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.groupseven.serviceuser.pojo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    void updateScore(@Param("id") int id, @Param("delta") int delta);

    @Update("update qlm_user set avatar = #{avatar} where id = #{id}")
    void updateAvatarById(String avatar, Integer id);
}
