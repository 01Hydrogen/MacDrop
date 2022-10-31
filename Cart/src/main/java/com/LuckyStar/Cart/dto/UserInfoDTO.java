package com.LuckyStar.Cart.dto;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class UserInfoDTO {
    @NonNull private String userId;
    @NonNull private String userEmail;
    @NonNull private String cardNumber;
    @NonNull private String cardHolderName;
    @NonNull private String cvv;
}
