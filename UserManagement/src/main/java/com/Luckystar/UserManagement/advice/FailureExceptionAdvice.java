package com.Luckystar.UserManagement.advice;

import com.Luckystar.UserManagement.exception.FailureException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class FailureExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(FailureException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String FailureException(FailureException e){
        return e.getMessage();
    }
}
