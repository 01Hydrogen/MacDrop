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


    public ResOrdersDTO() {
        this.carts = new ArrayList<>();
    }
}
