package com.Luckystar.MenuSystem.business;

public class MenuNotFoundException extends RuntimeException{

    public MenuNotFoundException(String res_id) {
        super("Could not found menu with restaurant id: " + res_id);
    }
}
