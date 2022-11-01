package com.Luckystar.Bookstore.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.Value;

//@Value
@Getter
@Setter

@ToString
public class InvoiceDTO {
  private String itemId;
  private String itemName;
  private Double price;
  private int amount;

}
