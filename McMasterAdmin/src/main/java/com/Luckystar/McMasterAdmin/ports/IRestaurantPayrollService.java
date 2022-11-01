package com.Luckystar.McMasterAdmin.ports;

import com.Luckystar.McMasterAdmin.dto.*;
import com.Luckystar.McMasterAdmin.exception.NoBillsException;

import java.util.List;

public interface IRestaurantPayrollService {
    //接收从Tracking传来的订单
    boolean createPayroll(RestaurantPayrollDTO restaurantPayrollDTO);
    //向管理员显示各餐厅明细
    List<ShowOrderDetailsDTO> showOrderDetails();
    //向payment service付款
    PayPriceDTO payPrice(String restaurantId) throws NoBillsException;
    //并将明细给餐厅
    EmailServiceDTO sendEmailToRestaurant(String restaurantId) throws NoBillsException;
    //付款并发送邮件后所有被处理的订单paid改为true
    void setPaid(String restaurantId);
    //每周一早上8点向学生发放上周的MDD
    List<CalcMDDDTO> calcMDD();
}
