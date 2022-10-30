package com.Luckystar.Bookstore.business.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor //@RequiredArgsConstructor
@Getter @Setter
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
//账单本database
public class BillBook {

  @GeneratedValue(generator = "jpa-uuid")
  @Id @NonNull
  private String Id ;

  private @NonNull String itemId;
  private @NonNull int amount;
  private @NonNull boolean checked; //是否已经结算
  private @NonNull LocalDate date;


  public BillBook(String itemId, int amount, boolean checked, LocalDate date) {
    this.itemId = itemId;
    this.amount = amount;
    this.checked = checked;
    this.date = date;
  }
}
