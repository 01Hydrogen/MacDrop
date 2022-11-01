package com.LuckyStar.TrackingSystem.business.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String subOrder_id;

    @NonNull
    private Double price;
    @NonNull
    private int amount;
    @NonNull @Column(name="res_id")
    private String resId;
    private Date delivered_Time;
    /**
     * -1 = rejected, 0 = created, 1 = preparing, 2 =  order ready to be picked up, 3 = biker delivering, 4 = order delivered, 5 = order close
     */
    private int status;

    /**
     * Spring JPA will auto generate column OrderInfo_id as foreign Key in our db table mapped to OrderInfo Table.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private OrderInfo orderInfo;

    public SubOrderInfo(@NonNull Double price, @NonNull int amount, @NonNull String resId, Date delivered_Time, int status) {
        this.price = price;
        this.amount = amount;
        this.resId = resId;
        this.delivered_Time = delivered_Time;
        this.status = status;
    }
}
