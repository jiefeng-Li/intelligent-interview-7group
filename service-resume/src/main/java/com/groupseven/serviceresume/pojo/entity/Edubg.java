package com.groupseven.serviceresume.pojo.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Edubg {
    private Integer id;
    private Integer resumeId;
    private String school;
    private String major;
    private String highestDegree;
    private LocalDate startDate;
    private LocalDate graduateDate;
    private Integer sort;
}
