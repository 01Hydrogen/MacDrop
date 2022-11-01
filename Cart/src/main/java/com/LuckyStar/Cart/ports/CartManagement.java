package com.LuckyStar.Cart.ports;

import com.LuckyStar.Cart.business.entities.Cart;
import com.LuckyStar.Cart.dto.CartRegistrationRequest;

public interface CartManagement {
    Cart add(CartRegistrationRequest item);
    void deleteSingleCart(String id);
    void deleteAllCart(String user_id);

}
