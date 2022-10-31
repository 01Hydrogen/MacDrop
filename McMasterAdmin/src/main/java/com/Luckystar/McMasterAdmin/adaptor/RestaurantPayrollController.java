package com.Luckystar.McMasterAdmin.adaptor;

import com.Luckystar.McMasterAdmin.dto.RestaurantPayrollDTO;
import com.Luckystar.McMasterAdmin.ports.IRestaurantPayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/McMasterAdmin/restaurant")
public class RestaurantPayrollController {

    @Autowired
    IRestaurantPayrollService restaurantPayrollService;

    /**
     * 接收Tracking传来的订单
     * @param restaurantPayrollDTO
     * @return
     */
    @RequestMapping(value = "/createPayroll")
    @ResponseBody
    public String createPayroll(@RequestBody RestaurantPayrollDTO restaurantPayrollDTO){
        restaurantPayrollService.createPayroll(restaurantPayrollDTO);
        return null;
    }

    /**
     * 向payment service付款，并将明细给餐厅
     */
    @RequestMapping(value = "/payPrice")
    public void payPrice(){

    }
}
