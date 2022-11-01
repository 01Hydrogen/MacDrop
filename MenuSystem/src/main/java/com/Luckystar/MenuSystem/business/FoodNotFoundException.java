package com.Luckystar.MenuSystem.business;

public class FoodNotFoundException extends RuntimeException{

    public FoodNotFoundException(String id) {
        super("Could not found food with id: " + id);
    }
}
