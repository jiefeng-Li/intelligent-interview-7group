package com.groupseven.serviceresume.pojo.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class WorkDTO {
    private Integer resumeId;
    private String entName;
    private String position;
    private LocalDate hireDate;
    private LocalDate leaveDate;
    private String content;
}
