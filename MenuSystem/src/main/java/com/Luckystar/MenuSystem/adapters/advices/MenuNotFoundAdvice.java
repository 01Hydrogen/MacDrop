package com.Luckystar.MenuSystem.adapters.advices;

import com.Luckystar.MenuSystem.business.MenuNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MenuNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(MenuNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String menuNotFoundHandler(MenuNotFoundException ex){
        return ex.getMessage();
    }
}
