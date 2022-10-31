package com.Luckystar.Bookstore.business.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Item {

  @Id @NonNull
  private  String id;

  @NonNull @Column(name = "ITEMNAME")
  private  String itemName;
  private @NonNull Double price;



}
