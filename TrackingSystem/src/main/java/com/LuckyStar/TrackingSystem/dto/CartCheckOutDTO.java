package com.LuckyStar.TrackingSystem.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/**
 * Received from cart, contains all the info of a order from student, classified by ResOrderDTO, each ResOrderDTO contains all the cart for a restaurant
 */
public class CartCheckOutDTO implements Serializable {
    @NonNull
    private List<ResOrdersDTO> restaurantOrders;
    @NonNull
    private Double totalPrice;
    @NonNull
    private String userId;
    @NonNull
    private String userEmail;
    private String transactionId;
}
