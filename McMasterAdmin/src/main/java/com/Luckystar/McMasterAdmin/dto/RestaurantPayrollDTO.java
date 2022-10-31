package com.Luckystar.McMasterAdmin.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RestaurantPayrollDTO {
    @NonNull
    private String order_id;

    @NonNull
    private String student_id;

    @NonNull
    private List<MenuInfoDTO> menuInfoDTOList; // Json Object:
    /**
     * String menu_name, Double price, Integer amount, String res_id
     */
}
