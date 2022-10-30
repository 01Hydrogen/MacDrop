package com.LuckyStar.Cart.adapters;

import com.LuckyStar.Cart.business.entities.Cart;
import com.LuckyStar.Cart.dto.CartRegistrationRequest;
import com.LuckyStar.Cart.ports.CartFinder;
import com.LuckyStar.Cart.ports.CartManagement;
import com.LuckyStar.Cart.ports.ICartCheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.LuckyStar.Cart.dto.CartCheckOutDTO;

import java.util.List;

@RestController
@RequestMapping(produces = "application/json")
public class CartController {

    private static final String ENDPOINT = "/cart";
    private final CartFinder registry;
    private final CartManagement manager;
    private final ICartCheckOutService cartCheckOut;

    @Autowired
    public CartController(CartFinder registry, CartManagement manager, ICartCheckOutService cartCheckOut) {
        this.registry = registry;
        this.manager = manager;
        this.cartCheckOut = cartCheckOut;
    }

    /**
     *
      */


    /**
     * get all carts in the system
     * @return
     */
    @GetMapping(ENDPOINT)
    public List<Cart> findAll(){
        return registry.findAll();
    }

    /**
     * get all carts from a single user
     * @return
     */
    @GetMapping(ENDPOINT + "/{id}")
    public List<Cart> findByUserId(@PathVariable String id){
        return registry.findByUserId(id);
    }
    /**
     * add single cart to db
     * @param cart
     * @return
     */
    @PostMapping(ENDPOINT)
    public Cart addCart(@RequestBody CartRegistrationRequest cart){
        return manager.add(cart);
    }

    /**
     * Delete a specific cart
     * @param id
     */
    @DeleteMapping(ENDPOINT+"/{id}")
    public void deleteCart(@PathVariable String id){
        manager.deleteSingleCart(id);
    }

    /**
     * Delete all user related carts
     * @param user_id
     */
    @DeleteMapping(ENDPOINT+"/user" + "/{user_id}")
    @Transactional
    public void deleteUserCarts(@PathVariable String user_id){
        manager.deleteAllCart(user_id);
    }

    /**
     * User Check Out Cart
     * @param user_id
     * @return
     */
    @PostMapping(ENDPOINT+"/{user_id}")
    public CartCheckOutDTO cartCheckOut(String user_id){
        return cartCheckOut.cartCheckOut(user_id);
    }
}
