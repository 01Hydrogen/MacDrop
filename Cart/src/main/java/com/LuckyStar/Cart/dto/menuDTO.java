package com.LuckyStar.Cart.dto;

import lombok.*;

import java.io.Serializable;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class menuDTO implements Serializable {
    @NonNull
    private String id;
    @NonNull
    private String resId;
    @NonNull
    private String name;
    @NonNull
    private Double price;
}
