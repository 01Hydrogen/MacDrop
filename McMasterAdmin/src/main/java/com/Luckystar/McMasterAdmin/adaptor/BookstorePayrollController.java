package com.Luckystar.McMasterAdmin.adaptor;

import com.Luckystar.McMasterAdmin.dto.PayPriceDTO;
import com.Luckystar.McMasterAdmin.ports.IBookstorePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/McMasterAdmin/bookstore")
public class BookstorePayrollController {

    @Autowired
    private IBookstorePayrollService bookstorePayrollService;

    /**
     * 接收bookstore发来的金额，并储存
     * @param price
     */
    @RequestMapping(value = "/savePrice",method = RequestMethod.POST)
    public void savePrice(@RequestBody Double price){
        bookstorePayrollService.savePrice(price);
    }

    /**
     * 审批并付款
     */
    @RequestMapping(value = "/approve",method = RequestMethod.PUT)
    public void approve(){
        try {
            List<PayPriceDTO> payPriceDTOList= bookstorePayrollService.approve();
            for (PayPriceDTO p: payPriceDTOList
                 ) {
                System.out.println("请求Payment system"+p.toString());
            }
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

}
