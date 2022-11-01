package com.LuckyStar.TrackingSystem.business.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


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
  private @NonNull @Column(name = "student_id") String studentId;

  @NonNull @Column(name = "student_email")
  private String studentEmail;
  @Column(name = "biker_id")
  private String bikerId;
  @Column(name = "created_time")
  private @NonNull Date createdTime;
  @Column(name = "delivered_time")
  private Date deliveredTime;
  private @NonNull Double totalPrice;
  /**
   * 0 = created, 1 = pending, 2 order delivered, 3 = order close
   */
  private @NonNull int status;
  @NonNull @Column(name = "carts_item", length = 2000)
  private String cartItems;
  @Column(name = "delivered_location")
  private @NonNull String deliveredLocation;
  @Column(name="delivered_timeslot")
  private @NonNull int deliveredTimeSlot;     //index0-5 from 11am to 4pm

  /**
   * this is just a relation defined in here, indicating there is a mappiong relation to SubOrderinfo table, it does nothing to our db, wont change column
   */
  @NonNull
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "orderInfo")
  private List<SubOrderInfo> subOrderInfo;
  public OrderInfo(@NonNull String studentId, @NonNull String studentEmail,String bikerId ,@NonNull Date createdTime, Date deliveredTime, @NonNull Double totalPrice, @NonNull int status, @NonNull String cartItems, @NonNull String deliveredLocation, @NonNull int deliveredTimeSlot) {
    this.studentId = studentId;
    this.studentEmail = studentEmail;
    this.bikerId = bikerId;
    this.createdTime = createdTime;
    this.deliveredTime = deliveredTime;
    this.totalPrice = totalPrice;
    this.status = status;
    this.cartItems = cartItems;
    this.deliveredLocation = deliveredLocation;
    this.deliveredTimeSlot = deliveredTimeSlot;
  }
}
