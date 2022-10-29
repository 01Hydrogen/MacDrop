package com.LuckyStar.Cart.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class CartRegistrationRequest {
    @NonNull
    private String Id;

    @NonNull @JsonProperty("user_id")
    private String userId;
    @NonNull
    @JsonProperty("menu_Id")
    private String menuId;
    @NonNull
    private Integer amount;
}
