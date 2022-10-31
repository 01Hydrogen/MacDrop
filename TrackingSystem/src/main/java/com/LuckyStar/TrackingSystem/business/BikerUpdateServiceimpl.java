package com.LuckyStar.TrackingSystem.business;

import com.LuckyStar.TrackingSystem.business.entities.OrderInfo;
import com.LuckyStar.TrackingSystem.dto.BikerUpdateDTO;
import com.LuckyStar.TrackingSystem.ports.IBikerUpdateService;
import com.LuckyStar.TrackingSystem.ports.OrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BikerUpdateServiceimpl implements IBikerUpdateService {
    private OrderStatusRepository orderStatusRepository;
    private final Integer DELIVERINGSTATUS = 3;
    private final Integer DELIVEREDSTATUS = 4;

    @Autowired
    public BikerUpdateServiceimpl(OrderStatusRepository orderStatusRepository) {
        this.orderStatusRepository = orderStatusRepository;
    }

    @Override
    public void statusUpdate(BikerUpdateDTO bikerUpdateDTO) {
        OrderInfo order = orderStatusRepository.findById(bikerUpdateDTO.getOrderId()).orElse(null);
        if(order == null){
            throw new OrderNotFoundException(bikerUpdateDTO.getOrderId());
        }

        /**
         * when biker first selected the order, we don't change order status, we just assign bikerId to selected order
         * when biker picked up the order, or delivered the order we change the status.
         */
        if(order.getBikerId() == null) order.setBikerId(bikerUpdateDTO.getBikerId());
        if(bikerUpdateDTO.getStatus() == DELIVERINGSTATUS || bikerUpdateDTO.getStatus() == DELIVEREDSTATUS) order.setStatus(bikerUpdateDTO.getStatus());

        /**
         * if biker delivered the order, we can auto set delivered time by Date
         */
        if(bikerUpdateDTO.getStatus() == DELIVEREDSTATUS){
            order.setDeliveredTime(new Date());
        }

        orderStatusRepository.save(order);

        /**
         * send out Email to student to Notify biker change the status
         */
    }
}
