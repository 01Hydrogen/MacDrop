package com.LuckyStar.TrackingSystem.dto;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResUpdateDTO {
    @NonNull
    private String orderId;
    @NonNull
    private int status;
}
