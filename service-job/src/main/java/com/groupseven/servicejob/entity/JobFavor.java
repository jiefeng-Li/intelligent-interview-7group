package com.groupseven.servicejob.entity;

import lombok.Data;

import java.util.Date;

@Data
public class JobFavor {
    private int id;
    private int jobId;
    private int userId;
    private Date favorName;
}
