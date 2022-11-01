package com.LuckyStar.Cart.dto;

import lombok.*;

/**
 * Response from paymentSystem
 */
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
    /**
     * transactionId from bank, in concatenating form
     */
    @NonNull
    private String transactionId;
}
