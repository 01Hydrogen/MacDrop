package com.LuckyStar.TrackingSystem.dto;

import com.LuckyStar.TrackingSystem.dto.CartPriceDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class ResOrdersDTO implements Serializable {

    private List<CartPriceDTO> carts;


    public ResOrdersDTO() {
        this.carts = new ArrayList<>();
    }
}
