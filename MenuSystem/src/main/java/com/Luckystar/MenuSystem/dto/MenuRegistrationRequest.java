package com.Luckystar.MenuSystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;


import lombok.*;
import java.io.Serializable;

@ToString
@Getter @Setter @NoArgsConstructor

public class MenuRegistrationRequest implements Serializable {
    @NonNull
    @JsonProperty("res_id")
    private String resId;
    @NonNull
    private String name;
    private Double price;
    private String description;
    private String picture_url;

}
