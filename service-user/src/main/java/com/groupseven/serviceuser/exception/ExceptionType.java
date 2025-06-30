package com.groupseven.serviceuser.exception;

import lombok.Getter;

@Getter
public enum ExceptionType {
    USER_NOT_FOUND(40001,"用户不存在"),
    USER_PASSWORD_ERROR(40002,"用户密码错误"),
    JWT_VALIDATE_ERROR(40003,"JWT验证错误");

    private int code;
    private String msg;

    ExceptionType(int code,String msg){
        this.code = code;
        this.msg = msg;
    }
}
