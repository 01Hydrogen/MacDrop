package com.LuckyStar.Cart.business;

import com.LuckyStar.Cart.business.entities.Cart;
import com.LuckyStar.Cart.dto.CartRegistrationRequest;
import com.LuckyStar.Cart.ports.CartManagement;
import com.LuckyStar.Cart.ports.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CartManager implements CartManagement {
    private CartRepository cartRepository;

    @Autowired
    public CartManager(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    private boolean exists(Cart cart) {
        if (!Objects.isNull(cart.getId())){
            return cartRepository.findById(cart.getId()).isPresent();
        } else {
            return false;
        }
    }

    @Override
    public Cart add(CartRegistrationRequest cart){
        Cart singleCart = new Cart(cart.getId(),cart.getUserId(), cart.getResId() ,cart.getMenuId(),cart.getAmount());
        if(exists(singleCart)) {
            throw new IllegalArgumentException("cart Already exists");
        }
        Cart saved = cartRepository.save(singleCart);
        return saved;
    }

    @Override
    public void deleteSingleCart(String id) {
        cartRepository.deleteById(id);
    }

    @Override
    public void deleteAllCart(String user_id) {
        cartRepository.deleteAllByUserId(user_id);
    }


}
