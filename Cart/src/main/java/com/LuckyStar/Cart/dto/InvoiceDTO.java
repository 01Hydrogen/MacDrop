package com.LuckyStar.Cart.dto;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class InvoiceDTO {
    @NonNull
    private Double totalPrice;
    @NonNull
    private String userId;
    /**
     * Binding with paymentInformation of a user such as credit card, name
     */
    @NonNull
    private UserInfoDTO paymentInfo;
}
