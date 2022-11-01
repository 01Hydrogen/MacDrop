package com.Luckystar.McMasterAdmin.advice;

import com.Luckystar.McMasterAdmin.exception.NoBillsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NoBillsAdvice {
    @ResponseBody
    @ExceptionHandler(NoBillsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String NoBillsExceptionHandler(NoBillsException e){
        return e.getMessage();
    }
}
