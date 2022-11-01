package com.LuckyStar.TrackingSystem.dto;

import lombok.NonNull;
import lombok.Value;

@Value
public class EmailResponseDTO {
    @NonNull
    int smtpStatusCode;
    @NonNull
    String smtpServerResponse;
}
