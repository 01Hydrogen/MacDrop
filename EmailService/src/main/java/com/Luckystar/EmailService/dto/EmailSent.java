package com.Luckystar.EmailService.dto;

import lombok.NonNull;
import lombok.Value;

@Value
public class EmailSent {
  int smtpStatusCode;
  String smtpServerResponse;


}
