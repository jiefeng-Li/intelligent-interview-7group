package com.groupseven.servicebase.pojo.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("qlm_industry")
public class IndustryDto {
    @TableId
    private Integer id;
    private String name;
    private Integer sort;
}
