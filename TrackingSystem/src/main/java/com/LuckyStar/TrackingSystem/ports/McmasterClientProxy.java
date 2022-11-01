package com.LuckyStar.TrackingSystem.ports;

import com.LuckyStar.TrackingSystem.dto.CompletedOrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name="mcmaster-admin")
public interface McmasterClientProxy {
    @RequestMapping(value = "/McMasterAdmin/restaurant/createPayroll",method = RequestMethod.POST)
    @ResponseBody
    public String createPayroll(@RequestBody CompletedOrderDTO completedOrderDTO);
}
