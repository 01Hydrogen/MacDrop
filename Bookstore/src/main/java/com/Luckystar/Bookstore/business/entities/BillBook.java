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

  @ManyToOne
  @JoinColumn(name = "item_id")
  private Item item;

  private @NonNull int amount;
  private @NonNull boolean checked; //是否已经结算
  private @NonNull LocalDate date;


  public BillBook(Item newItem, int amount, boolean checked, LocalDate date) {
    this.item = newItem;
    item.setId(newItem.getId());
    item.setItemName(newItem.getItemName());
    item.setPrice(newItem.getPrice());
    this.amount = amount;
    this.checked = checked;
    this.date = date;
  }
}
