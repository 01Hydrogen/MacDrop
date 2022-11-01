package com.LuckyStar.TrackingSystem.business;

public class SubOrderNotFoundException extends RuntimeException{
    public SubOrderNotFoundException(String order_id) {
        super("SubOrder Not found with subOrder ID: " + order_id);
    }
}
