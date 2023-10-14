package com.project.todo.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String msg){
        super(msg);
    }

}
