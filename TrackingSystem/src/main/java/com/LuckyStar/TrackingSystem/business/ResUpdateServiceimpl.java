package com.LuckyStar.TrackingSystem.business;

import com.LuckyStar.TrackingSystem.adapters.PaymentClientProxy;
import com.LuckyStar.TrackingSystem.business.entities.OrderInfo;
import com.LuckyStar.TrackingSystem.business.entities.SubOrderInfo;
import com.LuckyStar.TrackingSystem.dto.*;
import com.LuckyStar.TrackingSystem.ports.IResUpdateService;
import com.LuckyStar.TrackingSystem.ports.OrderStatusRepository;
import com.LuckyStar.TrackingSystem.ports.SubOrderStatusRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResUpdateServiceimpl implements IResUpdateService {
    private OrderStatusRepository orderStatusRepository;
    private SubOrderStatusRepository subOrderStatusRepository;
    private PaymentClientProxy paymentClientProxy;


    @Autowired
    public ResUpdateServiceimpl(OrderStatusRepository orderStatusRepository, SubOrderStatusRepository subOrderStatusRepository, PaymentClientProxy paymentClientProxy) {
        this.orderStatusRepository = orderStatusRepository;
        this.subOrderStatusRepository = subOrderStatusRepository;
        this.paymentClientProxy = paymentClientProxy;
    }

    public String orderRejected(OrderRejectedDTO orderRejectedDTO){
        /**
         * find the order by orderId, and update status to reject
         */
        SubOrderInfo subOrder = subOrderStatusRepository.findById(orderRejectedDTO.getSubOrderId()).orElse(null);
        if(subOrder == null){
            throw new OrderNotFoundException(orderRejectedDTO.getSubOrderId());
        }

        subOrder.setStatus(orderRejectedDTO.getStatus());
        subOrderStatusRepository.save(subOrder);

        /**
         * send email notifying the student that his/her order has been rejected by the restaurant
         */


        /**
         * send invoice(transactionId) to Payment, start refund process
         */

        RefundDTO refundDTO = new RefundDTO(subOrder.getTransactionId(), subOrder.getTotalPrice());
        Double refundAmount = paymentClientProxy.refund(refundDTO);

        OrderInfo order = subOrder.getOrderInfo();
        order.setTotalPrice(order.getTotalPrice() - refundAmount);
        orderStatusRepository.save(order);
        //OrderInfo orderInfo = orderStatusRepository.findById(order.getId()).orElse(null);

        return "Order Rejected and Total Price has been updated";
    }

    @Override
    public String statusUpdate(ResUpdateDTO resUpdateDTO) {
        /**
         * find the order and update its status
         */
        SubOrderInfo order = subOrderStatusRepository.findById(resUpdateDTO.getSubOrderId()).orElse(null);
        if(order == null){
            throw new OrderNotFoundException(resUpdateDTO.getSubOrderId());
        }

        order.setStatus(resUpdateDTO.getStatus());
        subOrderStatusRepository.save(order);

        /**
         * send email notifying the student the update
         */

        /**
         * if status was changed to close, then we send out this orderInfo to Mcmaster,
         * first, we will process the data to CompletedOrderDTO, then send through eureka.
         */


        return "Status Update";
    }

}
