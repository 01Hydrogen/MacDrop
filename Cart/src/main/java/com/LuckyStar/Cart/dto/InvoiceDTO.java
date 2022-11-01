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
     * concatenating form of restaurantID send to payment, received transactionId for each res_id in the same order.
     */
    private String res_id;
    /**
     * Binding with paymentInformation of a user such as credit card, name
     */
    @NonNull
    private UserInfoDTO paymentInfo;
}
