package com.Luckystar.PaymentSystem.dto;

import lombok.*;


@ToString
@Getter
@Setter
@AllArgsConstructor
public class InvoiceResponseDTO {
    @NonNull
    private Double priceAfterTax;
    @NonNull
    private String userId;
    @NonNull
    private String message;
    @NonNull
    private String transactionId;
}
