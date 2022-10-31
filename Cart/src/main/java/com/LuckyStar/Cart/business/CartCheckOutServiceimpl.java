package com.LuckyStar.Cart.business;

import com.LuckyStar.Cart.adapters.MenuClientProxy;
import com.LuckyStar.Cart.adapters.PaymentClientProxy;
import com.LuckyStar.Cart.adapters.TrackerClientProxy;
import com.LuckyStar.Cart.business.entities.Cart;
import com.LuckyStar.Cart.dto.*;
import com.LuckyStar.Cart.ports.CartRepository;
import com.LuckyStar.Cart.ports.ICartCheckOutService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
public class CartCheckOutServiceimpl implements ICartCheckOutService {
    private CartRepository cartRepository;
    private MenuClientProxy menuProxy;
    private PaymentClientProxy paymentProxy;

    private TrackerClientProxy trackerProxy;
    @Autowired
    public CartCheckOutServiceimpl(CartRepository cartRepository, MenuClientProxy menuProxy, PaymentClientProxy paymentProxy, TrackerClientProxy trackerProxy) {
        this.cartRepository = cartRepository;
        this.menuProxy = menuProxy;
        this.paymentProxy = paymentProxy;
        this.trackerProxy = trackerProxy;
    }

    @Override
    public CartCheckOutDTO cartCheckOut(UserInfoDTO userInfoDTO) {
        /**
         * start checkout process by first getting all the items info of this order
         * by searching user_id, we get all the items(cart) related to one user
         */
        List<Cart> carts = cartRepository.findByUserId(userInfoDTO.getUserId());

        /**
         * filter out all the restaurant id that selected in this order, also for each res_id, we create a new ResOrderDTO,
         * we will use these ResOrderDTO to do classification on orders
         */
        HashMap<String, ResOrdersDTO> restaurants = new HashMap<>();
        for(Cart cart:carts){
            if(!restaurants.containsKey(cart.getResId())){
                restaurants.put(cart.getResId(), new ResOrdersDTO());
            }
        }

        /**
         * communicate with menu service to get the menu of corresponding restaurant,
         * menuDTO is used to map all the menuInfo returned from Menu Service
         */
        List<MenuDTO> menus = menuProxy.findByResIds(String.join(",", restaurants.keySet()));

        /**
         * store each food price into HashTable
         */
        HashMap<String, Pair<Double,String>> priceTable = new HashMap<>();
        for(MenuDTO menu: menus){
            priceTable.put(menu.getId(), Pair.of(menu.getPrice(), menu.getName()));
        }

        /**
         * translating each item(cart) into a CartPriceDTO,
         * CartPriceDTO contains a price field
         * so we have a list of ordered items with price
         * then we divide those CartPriceDTO by res_id, and put each CartPriceDTO into specific ResOrdersDTO
         * Also we calculate the total price while processing along the price
         */
        List<CartPriceDTO> cartPriceDTO = new ArrayList<>();
        Double totalPrice = 0.0;
        for(Cart cart:carts){
            Double price = priceTable.getOrDefault(cart.getMenuId(), Pair.of(0.0,"notFound")).getFirst();
            String menuName = priceTable.getOrDefault(cart.getMenuId(), Pair.of(0.0, "notFound")).getSecond();
            /**
             * if price is not found from the menu, means food is not register to the menu, we throw exception
             */
            if(price == 0.0) { throw new PriceNotFoundException(cart.getId(), cart.getMenuId());}
            totalPrice += price;
            restaurants.get(cart.getResId()).getCarts().add(new CartPriceDTO(cart.getId(), price, cart.getMenuId(), cart.getResId(), cart.getAmount(), menuName));
        }

        /**
         * Summarize all restaurants Orders(ResOrdersDTO) in to a list
         */

        List<ResOrdersDTO> resOrders = new ArrayList<>();
        for(ResOrdersDTO r: restaurants.values()){
            resOrders.add(r);
        }

        /**
         * Create CartCheckOutDTO, and be ready to send to paymentSystem
         */
        CartCheckOutDTO cartCheckOutInfo = new CartCheckOutDTO(resOrders, totalPrice, userInfoDTO.getUserId(), userInfoDTO.getUserEmail(),null);

        /**
        * send paymentInfo and total Price to Payment
        */
        InvoiceDTO invoiceDTO = new InvoiceDTO(cartCheckOutInfo.getTotalPrice(),cartCheckOutInfo.getUserId(), userInfoDTO);
        InvoiceResponseDTO invoiceResponseDTO = paymentProxy.createInvoice(invoiceDTO);
        log.info(invoiceResponseDTO.getMessage());

        /**
         * set price after tax. save banking transactionId
         */
        cartCheckOutInfo.setTotalPrice(invoiceResponseDTO.getPriceAfterTax());
        cartCheckOutInfo.setTransactionId(invoiceResponseDTO.getTransactionId());

        /**
         * Create Order in tracking system
         */

        trackerProxy.createOrder(cartCheckOutInfo);

        return cartCheckOutInfo;
    }
}
