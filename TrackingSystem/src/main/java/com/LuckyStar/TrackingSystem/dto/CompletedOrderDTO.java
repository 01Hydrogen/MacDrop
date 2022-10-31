package com.LuckyStar.TrackingSystem.dto;

import lombok.*;

import java.util.List;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class CompletedOrderDTO {
    @NonNull
    private String orderId;

    @NonNull
    private String studentId;

    @NonNull
    private List<ToMacDTO> orderInfo; // Json Object:
    /**
     * String menu_name, Double price, Integer amount, String res_id
     */

}
