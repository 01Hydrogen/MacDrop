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
    @Column(name = "subOrder_id")
    private String subOrderId;

    @NonNull @Column(name = "transaction_id")
    private String transactionId;

    @NonNull @Column(name="res_id")
    private String resId;
    private Date delivered_Time;
    /**
     * -1 = rejected, 0 = created, 1 = preparing, 2 =  order ready to be picked up, 3 = biker delivering, 4 = order delivered, 5 = order close
     */
    @NonNull
    private int status;

    @NonNull
    @Column(name="total_price")
    private Double totalPrice;
    @NonNull @Column(name = "order_details", length = 1000)
    private String orderDetails;


    /**
     *
     *
     *      @NonNull
     *     private Double price;
     *     @NonNull
     *     private int amount;
     *
     *       -1 = rejected, 0 = created, 1 = preparing, 2 =  order ready to be picked up, 3 = biker delivering, 4 = order delivered, 5 = order close
     *
     *      @NonNull
     *
            private int status;
     *
     *
     *
     *
     **/



    /**
     * Spring JPA will auto generate column OrderInfo_id as foreign Key in our db table mapped to OrderInfo Table.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private OrderInfo orderInfo;

    public SubOrderInfo(@NonNull String transactionId, @NonNull String resId, int status, Double totalPrice, String orderDetails) {
        this.transactionId = transactionId;
        this.resId = resId;
        this.status = status;
        this.orderDetails = orderDetails;
        this.totalPrice = totalPrice;
    }
}
