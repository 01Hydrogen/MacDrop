package com.LuckyStar.Cart.ports;

import com.LuckyStar.Cart.dto.CartCheckOutDTO;


public interface ICartCheckOutService {
    CartCheckOutDTO cartCheckOut(String user_id);
}
