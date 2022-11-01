package com.Luckystar.Delievery.advice;

import com.Luckystar.Delievery.exception.DropLocationCRUDException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DropLocationCRUDAdvice {

    @ResponseBody
    @ExceptionHandler(DropLocationCRUDException.class)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public String NotFoundExceptionHandler(DropLocationCRUDException e){
        return e.getMessage();
    }
}
