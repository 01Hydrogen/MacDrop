package com.LuckyStar.Cart.business;

import com.LuckyStar.Cart.adapters.MenuClientProxy;
import com.LuckyStar.Cart.business.entities.Cart;
import com.LuckyStar.Cart.dto.CartCheckOutDTO;
import com.LuckyStar.Cart.dto.CartPriceDTO;
import com.LuckyStar.Cart.dto.menuDTO;
import com.LuckyStar.Cart.ports.CartRepository;
import com.LuckyStar.Cart.ports.ICartCheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Service
public class CartCheckOutServiceimpl implements ICartCheckOutService {
    private CartRepository cartRepository;
    private MenuClientProxy proxy;

    @Autowired
    public CartCheckOutServiceimpl(CartRepository cartRepository, MenuClientProxy proxy) {
        this.cartRepository = cartRepository;
        this.proxy = proxy;
    }

    @Override
    public CartCheckOutDTO cartCheckOut(String user_id) {
        /**
         * start checkout process by first getting all the items info of this order
         * by searching user_id, we get all the items(cart) related to one user
         */
        List<Cart> carts = cartRepository.findByUserId(user_id);

        /**
         * filter out all the restaurant id that selected in this order
         */
        HashSet<String> restaurants = new HashSet<>();
        for(Cart cart:carts){
            restaurants.add(cart.getResId());
        }

        /**
         * communicate with menu service to get the menu of corresponding restaurant,
         * menuDTO is used to map all the menuInfo returned from Menu Service
         */
        List<menuDTO> menus = proxy.findByResIds(String.join(",", restaurants));

        /**
         * store each food price into HashTable
         */
        HashMap<String, Double> priceTable = new HashMap<>();
        for(menuDTO menu: menus){
            priceTable.put(menu.getId(), menu.getPrice());
        }

        /**
         * translating each item(cart) in the order into a CartPriceDTO,
         * CartPriceDTO contains a price field
         * so we have a list of ordered items with price
         */
        List<CartPriceDTO> cartPriceDTO = new ArrayList<>();
        Double totalPrice = 0.0;
        for(Cart cart:carts){
            Double price = priceTable.getOrDefault(cart.getMenuId(), 0.0);
            /**
             * if price is not found from the menu, means food is not register to the menu, we throw exception
             */
            if(price == 0.0) { throw new PriceNotFoundException(cart.getId(), cart.getMenuId());}
            totalPrice += price;
            cartPriceDTO.add(new CartPriceDTO(cart.getId(), price, cart.getMenuId(),cart.getAmount()));
        }

        /**
         * Create CartCheckOutDTO, and be ready to send to paymentSystem
         */
        CartCheckOutDTO cartCheckOutInfo = new CartCheckOutDTO(cartPriceDTO, totalPrice, user_id);
        return cartCheckOutInfo;
    }
}
