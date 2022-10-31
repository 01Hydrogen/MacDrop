package com.LuckyStar.TrackingSystem.dto;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class CompletedOrderDTO {
    @NonNull
    private String order_id;

    @NonNull
    private String student_id;

    @NonNull
    private CartItemsDTO orderInfo; // Json Object:
    /**
     * String menu_name, Double price, Integer amount, String res_id
     */

}
