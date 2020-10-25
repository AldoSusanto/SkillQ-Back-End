package com.skillq.main.util;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException{

    protected HttpStatus httpStatus;
    protected String errorCode;
    protected String errorMessage;

    public BusinessException(HttpStatus status, String errorCode, String errorMessage){
        super(errorMessage);
        this.httpStatus = status;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public BusinessException(String errorCode, String errorMessage){
        super(errorMessage);
        this.httpStatus = HttpStatus.CONFLICT;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
