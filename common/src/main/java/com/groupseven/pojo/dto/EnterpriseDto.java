package com.groupseven.pojo.dto;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("qlm_enterprise")
public class EnterpriseDto {
    private Integer id;
    private String name;
    private Integer userId;
    private Integer type;
    private Integer industry;
    private Integer scale;
    private String address;
    private String description;
    private String contact;
    private String phoneNumber;
    private String logo;
    private String status;
    private String isDeleted;
}
