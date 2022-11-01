package com.LuckyStar.TrackingSystem.ports;

import com.LuckyStar.TrackingSystem.dto.CartCheckOutDTO;

public interface IOrderCreateService {
    public void orderCreate(CartCheckOutDTO cartCheckOutDTO);
}
