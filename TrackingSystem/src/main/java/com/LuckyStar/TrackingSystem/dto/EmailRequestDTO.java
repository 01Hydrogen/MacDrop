package com.LuckyStar.TrackingSystem.dto;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@Value
public class EmailRequestDTO {
    private @NonNull String from;
    private @NonNull String to;
    private @NonNull String message;
    private @NonNull String body;
}
