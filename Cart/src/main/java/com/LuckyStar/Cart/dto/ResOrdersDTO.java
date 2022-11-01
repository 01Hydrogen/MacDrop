package com.LuckyStar.Cart.dto;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class ResOrdersDTO implements Serializable {

    private List<CartPriceDTO> carts;

    @NonNull
    private Double totalPrice;
    @NonNull
    private String transactionId;
    public ResOrdersDTO() {
        this.carts = new ArrayList<>();
        this.totalPrice = 0.0;
    }
    public ResOrdersDTO(Double totalPrice, String transactionId){
        this.carts = new ArrayList<>();
        this.totalPrice = totalPrice;
        this.transactionId = transactionId;
    }
}
