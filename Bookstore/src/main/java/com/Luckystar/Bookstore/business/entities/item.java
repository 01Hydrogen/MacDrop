package com.LuckyStar.Bookstore.business.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Item {

  private @Id @NonNull String id;
  private @NonNull @Column(name = "ITEMNAME") String itemName;
  private @NonNull Double price;



}
