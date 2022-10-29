package com.LuckyStar.Cart.business;

import com.LuckyStar.Cart.business.entities.Cart;
import com.LuckyStar.Cart.ports.CartFinder;
import com.LuckyStar.Cart.ports.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartRegistry implements CartFinder {
    private final CartRepository repository;

    @Autowired
    public CartRegistry(CartRepository repository){ this.repository = repository;}

    @Override
    public List<Cart> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Cart> findByUserId(String user_id) {
        return repository.findByUserId(user_id);
    }


}
