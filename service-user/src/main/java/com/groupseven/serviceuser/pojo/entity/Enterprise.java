package com.groupseven.serviceuser.pojo.entity;

import lombok.Data;

@Data
public class Enterprise {
    private int id;
    private String name;
    private int userId;
    private int type;
    private int industry;
    private int scale;
    private String address;
    private String description;
    private String contact;
    private String phoneNumber;
    private String logo;
    private String status;
    private String isDeleted;
} 