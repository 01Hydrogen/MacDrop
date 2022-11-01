package com.LuckyStar.Cart.business;

public class PriceNotFoundException extends  RuntimeException{
    public PriceNotFoundException(String cart_id, String menu_id) {
        super("Food price not found from menu with cart id: " + cart_id + " and menu id: " + menu_id);
    }
}
