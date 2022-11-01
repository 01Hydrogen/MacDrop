package com.LuckyStar.TrackingSystem.adapters;

import com.LuckyStar.TrackingSystem.dto.RefundDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="payment-service")
public interface PaymentClientProxy {
    String ENDPOINT = "/invoice";

    @PostMapping(ENDPOINT + "refund/")
    public Double refund(@RequestBody RefundDTO refundDTO);
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