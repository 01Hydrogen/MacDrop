package com.LuckyStar.TrackingSystem.business;

import com.LuckyStar.TrackingSystem.business.entities.OrderInfo;
import com.LuckyStar.TrackingSystem.dto.CartCheckOutDTO;
import com.LuckyStar.TrackingSystem.dto.CartItemsDTO;
import com.LuckyStar.TrackingSystem.dto.CartPriceDTO;
import com.LuckyStar.TrackingSystem.dto.ResOrdersDTO;
import com.LuckyStar.TrackingSystem.ports.IOrderCreateService;
import com.LuckyStar.TrackingSystem.ports.OrderStatusRepository;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderCreateServiceimpl implements IOrderCreateService {

    private OrderStatusRepository orderStatusRepository;

    @Autowired
    public OrderCreateServiceimpl(OrderStatusRepository orderStatusRepository) {
        this.orderStatusRepository = orderStatusRepository;
    }

    private boolean exists(OrderInfo order) {
        if (!Objects.isNull(order.getId())){
            return orderStatusRepository.findById(order.getId()).isPresent();
        } else {
            return false;
        }
    }

    @Override
    public void orderCreate(CartCheckOutDTO cartCheckOutDTO) {
        List<CartItemsDTO> cartItemsDTOList = new ArrayList<>();
        for(ResOrdersDTO restaurant: cartCheckOutDTO.getRestaurantOrders()){
            for(CartPriceDTO carts: restaurant.getCarts()){
                cartItemsDTOList.add(new CartItemsDTO(carts.getName(),carts.getPrice(), carts.getAmount(), carts.getResId()));
            }
        }

        OrderInfo order = new OrderInfo();
    }
}
