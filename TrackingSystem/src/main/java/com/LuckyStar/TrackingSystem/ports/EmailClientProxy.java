package com.LuckyStar.TrackingSystem.ports;

import com.LuckyStar.TrackingSystem.dto.EmailRequestDTO;
import com.LuckyStar.TrackingSystem.dto.EmailResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="email-service")
public interface EmailClientProxy {
    String ENDPOINT = "/EmailService";

    @PostMapping(ENDPOINT)
    public EmailResponseDTO process(@RequestBody EmailRequestDTO request);
}
