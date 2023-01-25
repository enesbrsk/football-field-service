package com.example.footballfield.exception;

import com.example.footballfield.enums.ErrorCode;
import org.springframework.http.HttpStatus;

public class GenericException  extends RuntimeException{

    private HttpStatus httpStatus;
    private ErrorCode errorCode;
    private String errorMessage;

    public GenericException(String errorMessage,ErrorCode errorCode,HttpStatus httpStatus){
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public GenericException(String errorMessage,ErrorCode errorCode){
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
