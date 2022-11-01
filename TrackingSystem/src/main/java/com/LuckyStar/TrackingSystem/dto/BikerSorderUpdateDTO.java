package com.LuckyStar.TrackingSystem.dto;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BikerSorderUpdateDTO {
    @NonNull
    private String subOrderId;
    @NonNull
    private int status;
}
