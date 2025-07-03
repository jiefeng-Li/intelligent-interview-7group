package com.groupseven.serviceresume.pojo.VO;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ResumeListVO {
    private Integer id;
    private Integer userId;
    private String name;
    private LocalDateTime refreshTime;
    private String hunterStatus;
    private String gender;
    private LocalDate birthdate;
    private String intent;
    private Integer workDuration;
    private String highestDegree;
    private Integer viewNum;
    private String status;
    private Integer arriveDate;
    private String def;
}
