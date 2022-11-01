package com.Luckystar.McMasterAdmin.ports;


import com.Luckystar.McMasterAdmin.dto.PayPriceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="payment-service")
public interface PaymentClientProxy {
    String ENDPOINT = "/invoice";

    @PostMapping(ENDPOINT + "/revenue" )
    public void revenue(@RequestBody PayPriceDTO payPriceDTO);
}
