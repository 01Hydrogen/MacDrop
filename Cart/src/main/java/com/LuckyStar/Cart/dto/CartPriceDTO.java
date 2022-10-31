package com.LuckyStar.Cart.dto;

import lombok.*;

import java.io.Serializable;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartPriceDTO implements Serializable {
    @NonNull
    private String id;
    @NonNull
    private Double price;
    @NonNull
    private String menuId;
    @NonNull
    private String resId;
    @NonNull
    private Integer amount;
    @NonNull
    private String name;

}
