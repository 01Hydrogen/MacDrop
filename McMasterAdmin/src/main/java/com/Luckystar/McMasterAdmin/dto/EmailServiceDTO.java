package com.Luckystar.McMasterAdmin.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailServiceDTO {
    private String body;
    private String message;
    private String from;
    private String to;
}
