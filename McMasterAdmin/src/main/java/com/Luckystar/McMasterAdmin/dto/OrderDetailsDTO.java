package com.Luckystar.McMasterAdmin.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailsDTO {
    String orderId;
    double price;
    int amount;
    String restaurantId;
}
