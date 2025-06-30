package com.groupseven.servicebase.pojo.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("qlm_region")
public class Region {
    @TableId
    private Integer id;
    private Integer pid;
    private String name;
    private String letter;
    private Integer sort;
}
