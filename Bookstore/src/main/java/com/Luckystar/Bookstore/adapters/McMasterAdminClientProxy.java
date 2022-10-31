package com.Luckystar.Bookstore.adapters;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "mcmaster-admin")
public interface McMasterAdminClientProxy {
    final String ENDPOINT="/McMasterAdmin/bookstore";

    @RequestMapping(value = ENDPOINT+"/savePrice",method = RequestMethod.POST)
    public void savePrice(@RequestBody Double price);

}
