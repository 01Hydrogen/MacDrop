package com.Luckystar.UserManagement.exception;

import org.aspectj.bridge.Message;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String message){
        super(message);
    }
}
