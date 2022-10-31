package com.LuckyStar.TrackingSystem.business;

import com.LuckyStar.TrackingSystem.adapters.PaymentClientProxy;
import com.LuckyStar.TrackingSystem.business.entities.OrderInfo;
import com.LuckyStar.TrackingSystem.dto.CompletedOrderDTO;
import com.LuckyStar.TrackingSystem.dto.OrderRejectedDTO;
import com.LuckyStar.TrackingSystem.dto.ResUpdateDTO;
import com.LuckyStar.TrackingSystem.dto.ToMacDTO;
import com.LuckyStar.TrackingSystem.ports.IResUpdateService;
import com.LuckyStar.TrackingSystem.ports.OrderStatusRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResUpdateServiceimpl implements IResUpdateService {
    private OrderStatusRepository orderStatusRepository;
    private PaymentClientProxy paymentClientProxy;
    private final Integer CLOSESTATUS = 5;

    @Autowired
    public ResUpdateServiceimpl(OrderStatusRepository orderStatusRepository, PaymentClientProxy paymentClientProxy) {
        this.orderStatusRepository = orderStatusRepository;
        this.paymentClientProxy = paymentClientProxy;
    }

    public String orderRejected(OrderRejectedDTO orderRejectedDTO){
        /**
         * find the order by orderId, and update status to reject
         */
        OrderInfo order = orderStatusRepository.findById(orderRejectedDTO.getOrderId()).orElse(null);
        if(order == null){
            throw new OrderNotFoundException(orderRejectedDTO.getOrderId());
        }

        order.setStatus(orderRejectedDTO.getStatus());
        orderStatusRepository.save(order);

        /**
         * send email notifying the student that his/her order has been rejected by the restaurant
         */


        /**
         * send invoice(transactionId) to Payment, start refund process
         */

        paymentClientProxy.refund(order.getTransactionId());

        return "Order Rejected";
    }

    @Override
    public String statusUpdate(ResUpdateDTO resUpdateDTO) {
        /**
         * find the order and update its status
         */
        OrderInfo order = orderStatusRepository.findById(resUpdateDTO.getOrderId()).orElse(null);
        if(order == null){
            throw new OrderNotFoundException(resUpdateDTO.getOrderId());
        }

        order.setStatus(resUpdateDTO.getStatus());
        orderStatusRepository.save(order);

        /**
         * send email notifying the student the update
         */

        /**
         * if status was changed to close, then we send out this orderInfo to Mcmaster,
         * first, we will process the data to CompletedOrderDTO, then send through eureka.
         */

        if(resUpdateDTO.getStatus() == CLOSESTATUS){
            String closed_orders = order.getCartItems();
            String[] closed_order = closed_orders.split("/");
            List<ToMacDTO> toMacDTOList = new ArrayList<>();

            /**
             * Deserialize Json String to toMacDTO, and create CompletedOrderDTO
             */
            Gson gson = new Gson();
            for(String each_restaurantOrder: closed_order){
                toMacDTOList.add(gson.fromJson(each_restaurantOrder, ToMacDTO.class));
            }

            CompletedOrderDTO completedOrderDTO = new CompletedOrderDTO(resUpdateDTO.getOrderId(), order.getStudentId(), toMacDTOList);

            /**
             * send CompletedOrderDTO to Mcmaster
             */

            return "Order Closed";

        }


        return "Status Update";
    }

}
