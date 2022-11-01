package com.LuckyStar.TrackingSystem.business;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(String order_id) {

        super("Order Not found with order ID: " + order_id);
    }
}
