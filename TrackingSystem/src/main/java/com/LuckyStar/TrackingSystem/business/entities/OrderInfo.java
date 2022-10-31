package com.LuckyStar.TrackingSystem.business.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
@ToString
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
//Tracking system order status
public class OrderInfo {
  @Id @NonNull @GeneratedValue(generator = "jpa-uuid")
  private String id;

  @NonNull @Column(name = "transaction_id")
  private String transactionId;

  private @NonNull @Column(name = "student_id") String studentId;

  @NonNull @Column(name = "student_email")
  private String studentEmail;
  @Column(name = "biker_id")
  private String bikerId;

  @NonNull
  @Column(name = "res_id")
  private String resId;

  @Column(name = "created_time")
  private @NonNull Date createdTime;
  @Column(name = "delivered_time")
  private Date deliveredTime;
  private @NonNull Double totalPrice;
  /**
   * -1 = rejected, 0 = created, 1 = preparing, 2 =  order ready to be picked up, 3 = biker delivering, 4 = order delivered, 5 = order close
   */
  private @NonNull int status;
  @NonNull @Column(name = "carts_item", length = 2000)
  private String cartItems;
  @Column(name = "delivered_location")
  private @NonNull String deliveredLocation;
  @Column(name="delivered_timeslot")
  private @NonNull int deliveredTimeSlot;     //index0-5 from 11am to 4pm

  @NonNull
  @OneToMany @JoinColumn(name = "subOrderInfo_id")
  private SubOrderInfo subOrderInfo;
  public OrderInfo(@NonNull String transactionId, @NonNull String studentId, @NonNull String studentEmail,String bikerId, @NonNull String resId ,@NonNull Date createdTime, Date deliveredTime, @NonNull Double totalPrice, @NonNull int status, @NonNull String cartItems, @NonNull String deliveredLocation, @NonNull int deliveredTimeSlot, @NonNull SubOrderInfo subOrderInfo) {
    this.transactionId = transactionId;
    this.studentId = studentId;
    this.studentEmail = studentEmail;
    this.bikerId = bikerId;
    this.resId = resId;
    this.createdTime = createdTime;
    this.deliveredTime = deliveredTime;
    this.totalPrice = totalPrice;
    this.status = status;
    this.cartItems = cartItems;
    this.deliveredLocation = deliveredLocation;
    this.deliveredTimeSlot = deliveredTimeSlot;
    this.subOrderInfo = subOrderInfo;
  }
}
