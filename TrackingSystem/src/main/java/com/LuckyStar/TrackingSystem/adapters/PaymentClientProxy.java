package com.LuckyStar.TrackingSystem.adapters;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="payment-service")
public interface PaymentClientProxy {
    String ENDPOINT = "/invoice";

    @PostMapping(ENDPOINT + "refund/" + "/{transactionId}")
    public void refund(@PathVariable String transactionId);
}


/**
 * @FeignClient(name="tracker-service")
 * public interface TrackerClientProxy {
 *     String ENDPOINT = "/order";
 *
 *     @PostMapping(ENDPOINT + "/created")
 *     public void createOrder(@RequestBody CartCheckOutDTO cartCheckOutDTO);
 *
 * }
 */