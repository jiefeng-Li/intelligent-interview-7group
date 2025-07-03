package com.groupseven.serviceresume.pojo.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author 老谭（<a href="http://www.woniuxy.com">蜗牛学苑</a>）
 */
@Data
public class Resume {
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
    private LocalDateTime createdTime;
    private LocalDateTime refreshTime;

    private Integer viewNum;
    private Integer favorNum;
    private String def;
    private String  status;
    private String isDeleted;
}


