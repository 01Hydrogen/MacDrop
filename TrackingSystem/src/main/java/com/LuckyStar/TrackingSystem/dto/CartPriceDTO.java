package com.LuckyStar.TrackingSystem.dto;


import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartPriceDTO {
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
