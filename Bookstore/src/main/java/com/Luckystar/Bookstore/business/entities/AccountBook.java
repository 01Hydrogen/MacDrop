package com.LuckyStar.Bookstore.business.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
//账单本database
public class AccountBook {
  private @Id @NonNull String Id;
  private @NonNull String itemId;
  private @NonNull int amount;
  private @NonNull boolean isChecked;  //是否已经结算

}
