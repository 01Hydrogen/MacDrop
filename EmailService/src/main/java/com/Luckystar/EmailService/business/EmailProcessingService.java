package com.Luckystar.EmailService.business;

import com.Luckystar.EmailService.dto.EmailSent;
import com.Luckystar.EmailService.dto.SendEmailContentDTO;
import com.Luckystar.EmailService.ports.IEmailProcessingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailProcessingService implements IEmailProcessingService {

  private static final int SUCCESS_CODE = 250;

  @Override
  public EmailSent send(SendEmailContentDTO request) {
    log.info("*** Processing Email Request ***");
    log.info("* - from:    " + request.getFrom());
    log.info("* - to:      " + request.getTo());
    log.info("* - Body:  " + request.getBody());
    log.info("* - Message: " + request.getMessage());
    log.info("*** Ending email request ***");
    return new EmailSent(SUCCESS_CODE, "OK");
  }
}
