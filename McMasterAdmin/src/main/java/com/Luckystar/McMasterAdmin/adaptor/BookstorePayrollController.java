package com.Luckystar.McMasterAdmin.adaptor;

import com.Luckystar.McMasterAdmin.ports.IBookstorePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public void saveBill(Double price){
        bookstorePayrollService.savePrice(price);
    }



}
