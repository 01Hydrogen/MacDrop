package com.Luckystar.Bookstore.business.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Item {

  @GeneratedValue(generator = "jpa-uuid")
  @Id @NonNull
  private  String id;

  @NonNull @Column(name = "ITEMNAME")
  private  String itemName;
  private @NonNull Double price;

  public Item(){
    super();
  }

  public Item(String id, String itemName, Double price) {
    this.id = id;
    this.itemName = itemName;
    this.price = price;
  }
}
