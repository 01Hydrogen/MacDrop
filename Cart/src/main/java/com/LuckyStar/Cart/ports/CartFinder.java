package com.LuckyStar.Cart.ports;

import com.LuckyStar.Cart.business.entities.Cart;

import java.util.List;

public interface CartFinder {
    List<Cart> findAll();
    List<Cart> findByUserId(String user_id);
}
