package com.Luckystar.McMasterAdmin.adaptor;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="payment-service")
public interface PaymentClientProxy {
    String ENDPOINT = "/invoice";

    @PostMapping(ENDPOINT + "refund/" + "/{transactionId}")
    public void refund(@PathVariable String transactionId);
}
