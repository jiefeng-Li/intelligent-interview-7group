package com.groupseven.serviceuser.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUser {
    private Integer id;
    private String account;
    private String password;
    private String code;
}
