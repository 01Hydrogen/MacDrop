package com.Luckystar.McMasterAdmin.adaptor;

import com.Luckystar.McMasterAdmin.dto.*;
import com.Luckystar.McMasterAdmin.ports.EmailClientProxy;
import com.Luckystar.McMasterAdmin.ports.IRestaurantPayrollService;
import com.Luckystar.McMasterAdmin.ports.PaymentClientProxy;
import com.Luckystar.McMasterAdmin.ports.UserManagementClientProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/McMasterAdmin/restaurant")
public class RestaurantPayrollController {

    @Autowired
    IRestaurantPayrollService restaurantPayrollService;

    @Autowired
    EmailClientProxy emailClientProxy;

    @Autowired
    PaymentClientProxy paymentClientProxy;

    @Autowired
    UserManagementClientProxy userManagementClientProxy;

    /**
     * 接收Tracking传来的订单
     * @param restaurantPayrollDTO
     * @return
     */
    @RequestMapping(value = "/createPayroll",method = RequestMethod.POST)
    @ResponseBody
    public String createPayroll(@RequestBody RestaurantPayrollDTO restaurantPayrollDTO){
        restaurantPayrollService.createPayroll(restaurantPayrollDTO);
        return null;
    }

    /**
     * 按餐厅ID查询每个餐厅当天的明细，并显示给管理员审批
     * @return
     */
    @RequestMapping(value = "/showOrderDetails",method = RequestMethod.GET)
    @ResponseBody
    public List<ShowOrderDetailsDTO> showOrderDetails(){
        try {
            return restaurantPayrollService.showOrderDetails();
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 向payment service付款，并将明细给餐厅,付款并发送邮件后所有被处理的订单paid改为true
     */
    @RequestMapping(value = "/payPrice",method = RequestMethod.GET)
    public void payPrice(String restaurantId){
        try {
            PayPriceDTO payPriceDTO= restaurantPayrollService.payPrice(restaurantId);
            paymentClientProxy.revenue(payPriceDTO);
            System.out.println("传给Payment system"+payPriceDTO.toString());
            EmailServiceDTO emailServiceDTO=restaurantPayrollService.sendEmailToRestaurant(restaurantId);
            emailClientProxy.process(emailServiceDTO);
            System.out.println("发送邮件"+emailServiceDTO);
            //付款并发送邮件后所有被处理的订单paid改为true
            restaurantPayrollService.setPaid(restaurantId);
//            ShowOrderDetailsDTO s=new Gson().fromJson(emailServiceDTO.getBody(),ShowOrderDetailsDTO.class);
//            System.out.println(s);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 每周一早上8点向学生发放上周的MDD
     */
    @RequestMapping(value = "/calcMDD",method = RequestMethod.GET)
    @Scheduled(cron = "0 0 8 ? * 1")
    public void calcMDD(){
        List<CalcMDDDTO> calcMDDDTOList= restaurantPayrollService.calcMDD();
        for (CalcMDDDTO c:calcMDDDTOList
             ) {
            userManagementClientProxy.MDDAdd(c);
            System.out.println("请求UserManagement"+c);
        }
    }
}
