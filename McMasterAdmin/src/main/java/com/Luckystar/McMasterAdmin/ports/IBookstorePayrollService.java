package com.Luckystar.McMasterAdmin.ports;

public interface IBookstorePayrollService {
    //接收bookstore发来的金额，并储存
    void savePrice(Double price);
}
