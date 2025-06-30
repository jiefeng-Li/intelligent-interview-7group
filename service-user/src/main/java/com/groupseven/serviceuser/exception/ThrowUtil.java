package com.groupseven.serviceuser.exception;

import lombok.Getter;

@Getter
public class ThrowUtil {
    public static void throwExceptoinif(boolean condition, RuntimeException e) {
        if (condition) {
            throw e;
        }
    }

    public static void throwExceptoinif(boolean condition, ExceptionType exceptionType) {
        throwExceptoinif(condition, new BusinessException(exceptionType));
    }

    public static void throwExceptoinif(boolean condition, ExceptionType e, String msg) {
        throwExceptoinif(condition, new BusinessException(e, msg));
    }
}
