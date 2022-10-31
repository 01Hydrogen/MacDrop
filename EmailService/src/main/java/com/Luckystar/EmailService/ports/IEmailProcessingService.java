package com.Luckystar.EmailService.ports;

import com.Luckystar.EmailService.dto.EmailSent;
import com.Luckystar.EmailService.dto.SendEmailContentDTO;

public interface IEmailProcessingService {

  EmailSent send(SendEmailContentDTO request);
}
