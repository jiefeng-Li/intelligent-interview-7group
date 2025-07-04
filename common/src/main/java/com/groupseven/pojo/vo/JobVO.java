package com.groupseven.pojo.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class JobVO {
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