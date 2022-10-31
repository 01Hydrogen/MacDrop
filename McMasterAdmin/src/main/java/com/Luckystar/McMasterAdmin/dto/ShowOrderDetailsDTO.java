package com.Luckystar.McMasterAdmin.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ShowOrderDetailsDTO {
    private String restaurantId;
    private List<OrderDetailsDTO> orderDetailsDTOList;
    private double totalPrice;
}
