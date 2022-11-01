package com.Luckystar.EmailService.dto;

import lombok.NonNull;
import lombok.Value;

@Value
public class SendEmailContentDTO {
  private @NonNull String from;
  private @NonNull String to;
  private @NonNull String message;
  private @NonNull String body;
}
