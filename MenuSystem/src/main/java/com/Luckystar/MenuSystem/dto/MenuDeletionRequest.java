package com.LuckyStar.MenuSystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;


@ToString
@Getter
@Setter
@NoArgsConstructor
public class MenuDeletionRequest implements Serializable {
    @NonNull
    private String id;
    @NonNull
    @JsonProperty("res_id")
    private String resId;

}
