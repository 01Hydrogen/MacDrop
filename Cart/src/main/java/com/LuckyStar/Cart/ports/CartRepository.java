package com.LuckyStar.Cart.ports;

import com.LuckyStar.Cart.business.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, String> {

}
