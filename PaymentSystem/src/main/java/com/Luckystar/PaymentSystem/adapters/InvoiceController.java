package com.Luckystar.PaymentSystem.adapters;

import com.Luckystar.PaymentSystem.dto.InvoiceResponseDTO;
import com.Luckystar.PaymentSystem.dto.InvoiceDTO;
import com.Luckystar.PaymentSystem.dto.PayrollDTO;
import com.Luckystar.PaymentSystem.dto.RefundDTO;
import com.Luckystar.PaymentSystem.ports.ICartInvoiceService;
import com.Luckystar.PaymentSystem.ports.IPayrollService;
import com.Luckystar.PaymentSystem.ports.IRefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(produces = "application/json")
public class InvoiceController {
    private final String ENDPOINT = "/invoice";
    private ICartInvoiceService cartInvoiceService;
    private IRefundService iRefundService;
    private IPayrollService payrollService;

    @Autowired
    public InvoiceController(ICartInvoiceService cartInvoiceService, IRefundService iRefundService, IPayrollService payrollService) {
        this.cartInvoiceService = cartInvoiceService;
        this.iRefundService = iRefundService;
        this.payrollService = payrollService;
    }

    @PostMapping (ENDPOINT)
    public InvoiceResponseDTO createInvoice(@RequestBody InvoiceDTO cart){
        return cartInvoiceService.createInvoice(cart);
    }

    @PostMapping(ENDPOINT + "refund/")
    public Double refund(@RequestBody RefundDTO refundDTO){
        return iRefundService.refundTranscation(refundDTO);
    }

    @PostMapping(ENDPOINT + "/revenue")
    public void pay(@RequestBody PayrollDTO payrollDTO){
        payrollService.pay(payrollDTO);
    }
}
