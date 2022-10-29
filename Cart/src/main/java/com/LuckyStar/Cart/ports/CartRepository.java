package com.LuckyStar.Cart.ports;

import com.LuckyStar.Cart.business.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, String> {
    List<Cart> findByUserId(String user_id);
    void deleteById(String id);
    void deleteAllByUserId(String user_id);
}
