package com.Luckystar.PaymentSystem.dto;


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
    @NonNull
    private UserInfoDTO paymentInfo;
}
