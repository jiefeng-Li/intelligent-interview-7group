package com.groupseven.serviceuser.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.time.LocalDate;

@Data
@TableName("qlm_userinfo")
public class UserInfo {
    private int id;
    private String name;
    private String gender;
    private LocalDate birthdate;
    private String phoneNumber;
    private String currAddress;
} 