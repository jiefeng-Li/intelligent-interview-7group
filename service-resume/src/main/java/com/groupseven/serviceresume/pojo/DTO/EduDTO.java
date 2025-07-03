package com.groupseven.serviceresume.pojo.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EduDTO {
    private Integer resumeId;
    private String school;
    private String major;
    private String highestDegree;
    private LocalDate startDate;
    private LocalDate graduateDate;
}
