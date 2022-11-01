package com.Luckystar.Bookstore.exception;

public class ItemNotFoundException extends RuntimeException{
  public ItemNotFoundException(String itemName){
    super("Could not find item: " + itemName);
  }
}
