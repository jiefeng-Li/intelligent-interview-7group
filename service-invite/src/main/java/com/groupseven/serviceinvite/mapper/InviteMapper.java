package com.groupseven.serviceinvite.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.groupseven.serviceinvite.pojo.dto.InviteDto;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface InviteMapper extends BaseMapper<InviteDto> {
}
