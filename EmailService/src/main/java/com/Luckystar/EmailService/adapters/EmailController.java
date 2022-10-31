package com.Luckystar.EmailService.adapters;

import com.Luckystar.EmailService.business.EmailProcessingService;
import com.Luckystar.EmailService.dto.EmailSent;
import com.Luckystar.EmailService.dto.SendEmailContentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = "application/json")
public class EmailController {
  private static final String ENDPOINT = "EmailService";
  private final EmailProcessingService service;

  @Autowired
  public EmailController(EmailProcessingService service) {
    this.service = service;
  }

  @PostMapping(ENDPOINT)
  public EmailSent process(@RequestBody SendEmailContentDTO request) {
    return service.send(request);
  }


}
