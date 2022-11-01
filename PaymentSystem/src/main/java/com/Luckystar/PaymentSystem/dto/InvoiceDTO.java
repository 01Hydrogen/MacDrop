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
    /**
     * concatenating form of restaurantID send to payment, received transactionId for each res_id in the same order.
     */
    private String res_id;
    @NonNull
    private UserInfoDTO paymentInfo;
}
