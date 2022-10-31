package com.Luckystar.PaymentSystem.dto;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class UserInfoDTO {
    @NonNull
    private String userId;
    @NonNull private String cardNumber;
    @NonNull private String cardHolderName;
    @NonNull private String cvv;
}