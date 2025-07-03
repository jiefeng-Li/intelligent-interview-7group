package com.groupseven.pojo.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @description qlm_job
 * @author lijiefeng
 * @date 2025-07-01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("qlm_job")
public class JobDto{
    private Integer id;
    private Integer entId;
    private String name;
    private String industry;
    private String description;
    private Integer minWage;
    private Integer maxWage;
    private Integer num;
    private String welfare;
    private LocalDateTime pubTime;
    private LocalDateTime refreshTime;
    private Integer viewNum;
    private Integer favorNum;
    private Integer deliveNum;
    private String status;
    private String isDeleted;
}