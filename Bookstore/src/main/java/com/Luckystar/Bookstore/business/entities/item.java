package com.LuckyStar.Bookstore.business.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class item {

  private @Id @NonNull String id;
  private @NonNull String itemName;
  private @NonNull Double price;



}
