package com.LuckyStar.Bookstore.business;

public class BillNotFoundException extends RuntimeException{
  public BillNotFoundException(){
    super("Could not find these bills");
  }
}
