package com.Luckystar.Bookstore.dto;

import com.Luckystar.Bookstore.business.entities.Item;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.Value;

import java.time.LocalDate;


@Value
@Getter @Setter
@ToString
public class BillBookDTO{
  private String id;
  //billBookDTO scan item barcode getting the id of item
  private String itemId;
  private int amount;

  private boolean checked;    //default false

  private LocalDate date;
}
