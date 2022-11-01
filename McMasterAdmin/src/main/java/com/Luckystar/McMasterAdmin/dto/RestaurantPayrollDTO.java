package com.Luckystar.McMasterAdmin.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RestaurantPayrollDTO {
    @NonNull
    private String orderId;

    @NonNull
    private String studentId;

    @NonNull
    private List<MenuInfoDTO> orderInfo; // Json Object:
    /**
     * String menu_name, Double price, Integer amount, String res_id
     */
}
