package com.Luckystar.McMasterAdmin.ports;

import com.Luckystar.McMasterAdmin.dto.PayPriceDTO;

import java.util.List;

public interface IBookstorePayrollService {
    //接收bookstore发来的金额，并储存
    void savePrice(Double price);
    //审批并付款
    List<PayPriceDTO> approve();
}
