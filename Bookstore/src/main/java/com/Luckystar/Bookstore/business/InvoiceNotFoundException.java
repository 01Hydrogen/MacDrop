package com.Luckystar.Bookstore.business;

public class InvoiceNotFoundException extends RuntimeException{
  public InvoiceNotFoundException(){
    super("No new invoice generated this week");
  }
}
