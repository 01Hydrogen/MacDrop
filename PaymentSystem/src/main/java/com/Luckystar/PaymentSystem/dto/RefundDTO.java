package com.Luckystar.PaymentSystem.dto;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class RefundDTO {
    @NonNull
    private String transactionId;
    @NonNull
    private Double totalPrice;
}
