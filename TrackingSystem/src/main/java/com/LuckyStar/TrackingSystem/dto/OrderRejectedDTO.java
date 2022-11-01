package com.LuckyStar.TrackingSystem.dto;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRejectedDTO {
    @NonNull
    private String subOrderId;
    @NonNull
    private int status;

    private String reason;
}
