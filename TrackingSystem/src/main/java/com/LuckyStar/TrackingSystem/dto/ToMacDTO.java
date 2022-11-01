package com.LuckyStar.TrackingSystem.dto;

import lombok.*;

/**
 * temporary dto used for storing correct data format in cart_items, as well send to
 */
@ToString
@Getter
@Setter
@AllArgsConstructor
public class ToMacDTO {
    @NonNull
    private String menuName;
    @NonNull
    private Double price;
    @NonNull
    private Integer amount;
    @NonNull
    private String resId;
}
