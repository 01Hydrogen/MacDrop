package com.Luckystar.Bookstore.business;

public class ItemNotFoundException extends RuntimeException{
  public ItemNotFoundException(String itemName){
    super("Could not find item: " + itemName);
  }
}
