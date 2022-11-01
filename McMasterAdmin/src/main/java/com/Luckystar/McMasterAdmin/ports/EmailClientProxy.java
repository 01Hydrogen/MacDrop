package com.Luckystar.McMasterAdmin.ports;

import com.Luckystar.McMasterAdmin.dto.EmailSent;
import com.Luckystar.McMasterAdmin.dto.EmailServiceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "email-service")
public interface EmailClientProxy {
    String ENDPOINT = "/EmailService";

    @RequestMapping(value = ENDPOINT,method = RequestMethod.POST)
    public EmailSent process(@RequestBody EmailServiceDTO request);
}
