package com.LuckyStar.Cart.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartCheckOutDTO {
    @NonNull
    private List<CartPriceDTO> carts;
    @NonNull
    private Double totalPrice;
    @NonNull @JsonProperty("user_id")
    private String userId;



}
