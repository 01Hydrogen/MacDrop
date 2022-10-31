package com.Luckystar.McMasterAdmin.ports;

import com.Luckystar.McMasterAdmin.dto.RestaurantPayrollDTO;

import java.util.List;

public interface IRestaurantPayrollService {
    //接收从Tracking传来的订单
    boolean createPayroll(RestaurantPayrollDTO restaurantPayrollDTO);
    //向payment service付款
    List payPrice();
    //并将明细给餐厅
    List sendEmailToRestaurant();
}
