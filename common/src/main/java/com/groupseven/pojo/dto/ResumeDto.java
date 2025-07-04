package com.groupseven.pojo.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;

@Data
@TableName("qlm_resume")
public class ResumeDto {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private String name;
    private String gender;
    private LocalDate birthdate;
    private Integer minWage;
    private Integer maxWage;
    private String intent;
    private Integer city;
    private String residence;
    private String highestDegree;
    private String telphone;
    private Integer workDuration;
    private String email;
    private Integer arriveDate;
    private String hunterStatus;
    private Integer industry;
    private LocalDate createdTime;
    private LocalDate refreshTime;
    private Integer viewNum;
    private Integer favorNum;
    private String def;
    private String  status;
    private String isDeleted;
}
