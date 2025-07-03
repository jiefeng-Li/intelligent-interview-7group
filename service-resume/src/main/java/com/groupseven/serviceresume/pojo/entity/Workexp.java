package com.groupseven.serviceresume.pojo.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Workexp {
    private Integer id;
    private Integer resumeId;
    private String entName;
    private String position;
    private LocalDate hireDate;
    private LocalDate leaveDate;
    private String content;
    private Integer sort;
}
