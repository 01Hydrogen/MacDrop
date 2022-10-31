package com.Luckystar.PaymentSystem.business;

public class InvoiceRejectedException extends RuntimeException{
    public InvoiceRejectedException(String user_id) {
        super("User: " + user_id + "payment refused, please try again");
    }
}
