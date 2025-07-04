package com.groupseven.servicejob.exception;

public class JobExistException extends RuntimeException {
    public JobExistException() {}
    public JobExistException(String message) {super(message);}
}
