package com.LuckyStar.TrackingSystem.business;

import com.LuckyStar.TrackingSystem.adapters.PaymentClientProxy;
import com.LuckyStar.TrackingSystem.business.entities.OrderInfo;
import com.LuckyStar.TrackingSystem.business.entities.SubOrderInfo;
import com.LuckyStar.TrackingSystem.dto.*;
import com.LuckyStar.TrackingSystem.ports.EmailClientProxy;
import com.LuckyStar.TrackingSystem.ports.IResUpdateService;
import com.LuckyStar.TrackingSystem.ports.OrderStatusRepository;
import com.LuckyStar.TrackingSystem.ports.SubOrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ResUpdateServiceimpl implements IResUpdateService {
    private OrderStatusRepository orderStatusRepository;
    private SubOrderStatusRepository subOrderStatusRepository;
    private PaymentClientProxy paymentClientProxy;

    private final EmailClientProxy emailClientProxy;

    private final static String MCMASTEREMAIL = "cas@mcmaster.ca";
    private final static String STATUSMESSAGE = "your order status has been changed to: ";
    private final HashMap<Integer, String> STATUS = new HashMap<Integer, String>(){{
        put(-1, "Rejected");
        put(1, "Preparing");
        put(2, "Ready to be picked up");
    }};


    @Autowired
    public ResUpdateServiceimpl(OrderStatusRepository orderStatusRepository, SubOrderStatusRepository subOrderStatusRepository, PaymentClientProxy paymentClientProxy, EmailClientProxy emailClientProxy) {
        this.orderStatusRepository = orderStatusRepository;
        this.subOrderStatusRepository = subOrderStatusRepository;
        this.paymentClientProxy = paymentClientProxy;
        this.emailClientProxy = emailClientProxy;
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

        emailClientProxy.process(new EmailRequestDTO(MCMASTEREMAIL, subOrder.getOrderInfo().getStudentEmail(), STATUSMESSAGE + STATUS.get(orderRejectedDTO.getStatus()) + "with the reason: " + orderRejectedDTO.getReason(), ""));

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
        SubOrderInfo subOrder = subOrderStatusRepository.findById(resUpdateDTO.getSubOrderId()).orElse(null);
        if(subOrder == null){
            throw new OrderNotFoundException(resUpdateDTO.getSubOrderId());
        }

        subOrder.setStatus(resUpdateDTO.getStatus());
        subOrderStatusRepository.save(subOrder);

        /**
         * send email notifying the student the update
         */

        emailClientProxy.process(new EmailRequestDTO(MCMASTEREMAIL, subOrder.getOrderInfo().getStudentEmail(), STATUSMESSAGE + STATUS.get(resUpdateDTO.getStatus()), ""));

        /**
         * if status was changed to close, then we send out this orderInfo to Mcmaster,
         * first, we will process the data to CompletedOrderDTO, then send through eureka.
         */


        return "Status Update";
    }

}
