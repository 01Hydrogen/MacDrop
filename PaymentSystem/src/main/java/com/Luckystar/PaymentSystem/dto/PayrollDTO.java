package com.Luckystar.PaymentSystem.dto;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class PayrollDTO {
    @NonNull
    private String targetId;
    @NonNull
    private Double revenue;
}
