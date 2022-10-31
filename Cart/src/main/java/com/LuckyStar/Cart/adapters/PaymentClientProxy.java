package com.LuckyStar.Cart.adapters;

import com.LuckyStar.Cart.dto.CartCheckOutDTO;
import com.LuckyStar.Cart.dto.InvoiceDTO;
import com.LuckyStar.Cart.dto.InvoiceResponseDTO;
import com.LuckyStar.Cart.dto.UserInfoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="payment-service")
public interface PaymentClientProxy {
    String ENDPOINT = "/invoice";

    @PostMapping(ENDPOINT)
    public InvoiceResponseDTO createInvoice(@RequestBody InvoiceDTO cart);

}
