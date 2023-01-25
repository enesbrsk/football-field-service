package com.example.footballfield.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AreaNotFoundException extends RuntimeException{
    public AreaNotFoundException(String s){
        super(s);
    }
}
