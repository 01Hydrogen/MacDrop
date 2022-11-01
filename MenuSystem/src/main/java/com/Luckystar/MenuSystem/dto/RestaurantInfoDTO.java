package com.Luckystar.MenuSystem.dto;

import lombok.*;

import javax.persistence.Id;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class RestaurantInfoDTO {
    @NonNull
    private String userId;
    @NonNull
    private String name;
    private String logUrl;
}
