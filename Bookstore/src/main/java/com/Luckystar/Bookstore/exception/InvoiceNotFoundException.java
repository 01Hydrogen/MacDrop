package com.Luckystar.Bookstore.exception;

public class InvoiceNotFoundException extends RuntimeException{
  public InvoiceNotFoundException(){
    super("No new invoice generated this week");
  }
}
