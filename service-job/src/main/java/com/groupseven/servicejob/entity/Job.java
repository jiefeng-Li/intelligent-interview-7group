package com.groupseven.servicejob.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@TableName("qlm_job")
@Data
public class Job {
    @TableId(type = IdType.AUTO)
    private int id;
    private int entId;
    private String name;
    private String industry;
    private String description;
    private int minWage;
    private int maxWage;
    private int num;
    private String welfare;
    private LocalDateTime pubTime;
    private LocalDateTime refreshTime;
    private int viewNum;
    private int favorNum;
    private int deliveNum;
    private String status;
    private String isDeleted;
}
