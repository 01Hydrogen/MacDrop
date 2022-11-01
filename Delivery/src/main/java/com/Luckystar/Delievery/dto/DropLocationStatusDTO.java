package com.Luckystar.Delievery.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DropLocationStatusDTO {
    private String locationName;
    private int[] locationStatus;
}
