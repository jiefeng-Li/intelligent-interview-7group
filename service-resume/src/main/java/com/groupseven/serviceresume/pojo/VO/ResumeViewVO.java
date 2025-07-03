package com.groupseven.serviceresume.pojo.VO;

import com.groupseven.serviceresume.pojo.entity.Edubg;
import com.groupseven.serviceresume.pojo.entity.Workexp;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ResumeViewVO {
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
    private List<Workexp> workexpList;
    private List<Edubg> edubgList;
}
