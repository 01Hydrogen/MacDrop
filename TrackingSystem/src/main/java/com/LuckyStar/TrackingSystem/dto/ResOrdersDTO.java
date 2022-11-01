package com.LuckyStar.TrackingSystem.dto;

import com.LuckyStar.TrackingSystem.dto.CartPriceDTO;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class ResOrdersDTO implements Serializable {
    @NonNull
    private List<CartPriceDTO> carts;
    @NonNull
    private String transactionId;
    @NonNull
    private Double totalPrice;


    public ResOrdersDTO() {
        this.carts = new ArrayList<>();
    }
}
