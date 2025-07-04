package com.groupseven.serviceuser.pojo.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Follow {
    private int id;
    private int entId;
    private int userId;
    private LocalDateTime followTime;
} 