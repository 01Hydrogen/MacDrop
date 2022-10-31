package com.LuckyStar.TrackingSystem.dto;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class CartItemsDTO {
    @NonNull
    private String menu_name;
    @NonNull
    private Double price;
    @NonNull
    private Integer amount;
    @NonNull
    private String res_id;
}
