package com.LuckyStar.Cart.adapters;

import com.LuckyStar.Cart.dto.CartCheckOutDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="tracker-service")
public interface TrackerClientProxy {
    String ENDPOINT = "/order";

    @PostMapping(ENDPOINT + "/created")
    public void createOrder(@RequestBody CartCheckOutDTO cartCheckOutDTO);

}
