package com.LuckyStar.Cart.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartCheckOutDTO implements Serializable {
    @NonNull
    private List<ResOrdersDTO> restaurantOrders;
    @NonNull
    private Double totalPrice;
    @NonNull
    private String userId;
    @NonNull
    private String userEmail;

}
