package com.groupseven.serviceuser.exception;

public class BusinessException extends RuntimeException{
    private int code ;

    public BusinessException(ExceptionType exceptionType) {
        super(exceptionType.getMsg());
        this.code = exceptionType.getCode();
    }

    public BusinessException(ExceptionType exceptionType, String message) {
        super(message);
        this.code = exceptionType.getCode();
    }
}
