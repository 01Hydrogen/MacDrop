package com.Luckystar.McMasterAdmin.dto;

import lombok.Value;

@Value
public class EmailSent {
  int smtpStatusCode;
  String smtpServerResponse;


}
