package com.LuckyStar.TrackingSystem.business.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.Date;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
@ToString
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class SubOrderInfo {
    @Id
    @NonNull @GeneratedValue(generator = "jpa-uuid")
    private String id;

    @NonNull
    private Double price;
    @NonNull
    private int amount;
    @NonNull @Column(name="res_id")
    private String resId;
    private Date delivered_Time;
    private int status;

    @ManyToOne
    private OrderInfo orderInfo;
}
