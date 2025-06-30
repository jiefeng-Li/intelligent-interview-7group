package com.groupseven.serviceuser.pojo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;


@TableName("qlm_user")
@Builder
@Data
public class User {
    @TableId(type = IdType.AUTO)
    private int id;
    private String account;
    private String password;
    private String email;
    private String phoneNumber;
    private String avatar;
    private LocalDateTime regTime;
    private String type;
    private int score;
    private String status;

//    private List<Score> scores;
}
