package com.groupseven.servicebase.pojo.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("qlm_industry")
public class Industry {
    private Integer id;
    private String name;
    private Integer sort;
}
