package com.LuckyStar.Cart.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class CartAllDeletionRequest {

    @NonNull
    @JsonProperty("user_id")
    private String userId;

}
