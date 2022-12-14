package com.LuckyStar.TrackingSystem.business;

import com.LuckyStar.TrackingSystem.business.entities.OrderInfo;
import com.LuckyStar.TrackingSystem.business.entities.SubOrderInfo;
import com.LuckyStar.TrackingSystem.dto.*;
import com.LuckyStar.TrackingSystem.ports.EmailClientProxy;
import com.LuckyStar.TrackingSystem.ports.IOrderCreateService;
import com.LuckyStar.TrackingSystem.ports.OrderStatusRepository;
import com.LuckyStar.TrackingSystem.ports.SubOrderStatusRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

@Service
public class OrderCreateServiceimpl implements IOrderCreateService {

    private final OrderStatusRepository orderStatusRepository;
    private final SubOrderStatusRepository subOrderStatusRepository;
    private final EmailClientProxy emailClientProxy;
    private final static String MCMASTEREMAIL = "cas@mcmaster.ca";
    private final static String ORDERCREATEMESSAGE = "your order has been created";
    @Autowired
    public OrderCreateServiceimpl(OrderStatusRepository orderStatusRepository, SubOrderStatusRepository subOrderStatusRepository, EmailClientProxy emailClientProxy) {
        this.orderStatusRepository = orderStatusRepository;
        this.subOrderStatusRepository = subOrderStatusRepository;
        this.emailClientProxy = emailClientProxy;
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
        String cart_items = "";
        Gson gson = new Gson();

        /**
         * convert each carts info into a JSON String, and saved into our cart_items field.
         */
        for(ResOrdersDTO restaurant: cartCheckOutDTO.getRestaurantOrders()){
            for(CartPriceDTO carts: restaurant.getCarts()){
                ToMacDTO toMacDTO = new ToMacDTO(carts.getName(),carts.getPrice(), carts.getAmount(), carts.getResId());
                cart_items += gson.toJson(toMacDTO) + "/";
            }
        }

        /**
         * first create a single big Order
         */

        OrderInfo order = new OrderInfo(cartCheckOutDTO.getUserId(), cartCheckOutDTO.getUserEmail(),
                null, new Date(), null,cartCheckOutDTO.getTotalPrice(), 0, cart_items, cartCheckOutDTO.getDeliverLocation(), cartCheckOutDTO.getDeliverTimeSlot());
        if(exists(order)) {
            throw new IllegalArgumentException("Order Already exists");
        }
        OrderInfo saved = orderStatusRepository.save(order);

        /**
         * Next, we divide a big Order into subOrders and store each SubOrder into our SubOrderInfo
         */
        OrderInfo orderInfo = new OrderInfo();
        for(ResOrdersDTO restaurant: cartCheckOutDTO.getRestaurantOrders()){
            String orderDetails = "";
            String resId = "";
            for(CartPriceDTO carts: restaurant.getCarts()) {
                ToMacDTO toMacDTO = new ToMacDTO(carts.getName(), carts.getPrice(), carts.getAmount(), carts.getResId());
                orderDetails += gson.toJson(carts) + "/";
                resId = carts.getResId();
            }
            SubOrderInfo subOrderInfo = new SubOrderInfo(restaurant.getTransactionId(),resId, 0, restaurant.getTotalPrice() ,orderDetails);
            subOrderInfo.setOrderInfo(saved);
            subOrderStatusRepository.save(subOrderInfo);
        }


        /**
         * Send Email to student, Notify successful order creation
         */

        EmailRequestDTO emailRequestDTO = new EmailRequestDTO(MCMASTEREMAIL, order.getStudentEmail(), ORDERCREATEMESSAGE, "");
        emailClientProxy.process(emailRequestDTO);

        /**
         * Send selected Time and location to Mcmaster for monitoring purpose
         */

        UseDropLocationDTO useDropLocationDTO = new UseDropLocationDTO(order.getDeliveredLocation(), order.getDeliveredTimeSlot());


    }
}
