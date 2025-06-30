package com.groupseven.serviceuser.pojo.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Score {
    private int id;
    private int userId;
    private String reason;
    private LocalDateTime recordTime;
    private int delta;
}