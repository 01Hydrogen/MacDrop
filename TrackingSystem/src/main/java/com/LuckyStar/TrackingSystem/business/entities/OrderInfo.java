package com.LuckyStar.TrackingSystem.business.entities;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Entity
@Getter@Setter
//Tracking system order status
public class OrderInfo {
  private @Id @NonNull String id;
  private @NonNull String studentId;
  private @NonNull String bikerId;
  private @NonNull Date createTime;
  private @NonNull Date deliveredTime;
  private @NonNull Double totalPrice;
  private @NonNull int status;      //0 = pending, 1 = paid
  private @NonNull String cartItems;
  private @NonNull String deliverLocation;
  private @NonNull int deliverTimeSlot;     //index0-5 from 11am to 4pm



}
