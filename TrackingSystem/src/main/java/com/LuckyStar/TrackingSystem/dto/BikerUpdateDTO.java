package com.LuckyStar.TrackingSystem.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BikerUpdateDTO {
    @NonNull
    private String orderId;
    @NonNull
    private String bikerId;
    @NonNull
    private int status;
}
