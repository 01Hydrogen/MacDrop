package com.Luckystar.PaymentSystem.adapters;

import com.Luckystar.PaymentSystem.dto.CartInvoiceDTO;
import com.Luckystar.PaymentSystem.dto.InvoiceDTO;
import com.Luckystar.PaymentSystem.ports.ICartInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(produces = "application/json")
public class InvoiceController {
    private final String ENDPOINT = "/invoice";
    private final ICartInvoiceService cartInvoiceService;

    @Autowired
    public InvoiceController(ICartInvoiceService cartInvoiceService) {
        this.cartInvoiceService = cartInvoiceService;
    }

    @PostMapping (ENDPOINT)
    public CartInvoiceDTO createInvoice(@RequestBody InvoiceDTO cart){
        return cartInvoiceService.createInvoice(cart);
    }
}
