package com.Luckystar.Bookstore.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.Value;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;


@Value
@Getter @Setter
@ToString
public class BillBookDTO implements Serializable {
  private String id;
  private String itemId;
  private int amount;

  private boolean checked;    //default false

  private LocalDate date;
}
