package com.LuckyStar.Cart.adapters;

import com.LuckyStar.Cart.business.entities.Cart;
import com.LuckyStar.Cart.ports.CartFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(produces = "application/json")
public class CartController {

    private static final String ENDPOINT = "/cart";
    private final CartFinder registry;

    @Autowired
    public CartController(CartFinder registry) {
        this.registry = registry;
    }

    @GetMapping(ENDPOINT)
    public List<Cart> findAll(){
        return registry.findAll();
    }
}
