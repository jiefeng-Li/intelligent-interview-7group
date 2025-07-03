package com.groupseven.serviceinvite.pojo.entity;

import lombok.Data;

import java.time.LocalDate;

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
    private LocalDate arriveDate;
    private String hunterStatus;
    private Integer industry;
    private LocalDate createdTime;
    private LocalDate refreshTime;
    private Integer viewNum;
    private Integer favorNum;
    private String def;
    private String  status;
    private String isDelete;
}