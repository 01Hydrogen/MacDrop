package com.LuckyStar.TrackingSystem.business;

import com.LuckyStar.TrackingSystem.business.entities.OrderInfo;
import com.LuckyStar.TrackingSystem.business.entities.SubOrderInfo;
import com.LuckyStar.TrackingSystem.dto.BikerSorderUpdateDTO;
import com.LuckyStar.TrackingSystem.dto.BikerUpdateDTO;
import com.LuckyStar.TrackingSystem.dto.CompletedOrderDTO;
import com.LuckyStar.TrackingSystem.dto.ToMacDTO;
import com.LuckyStar.TrackingSystem.ports.IBikerUpdateService;
import com.LuckyStar.TrackingSystem.ports.OrderStatusRepository;
import com.LuckyStar.TrackingSystem.ports.SubOrderStatusRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BikerUpdateServiceimpl implements IBikerUpdateService {
    private OrderStatusRepository orderStatusRepository;
    private final SubOrderStatusRepository subOrderStatusRepository;
    private final Integer DELIVERINGSTATUS = 3;
    private final Integer DELIVEREDSTATUS = 4;
    private final Integer CLOSESTATUS = 2;

    @Autowired
    public BikerUpdateServiceimpl(OrderStatusRepository orderStatusRepository, SubOrderStatusRepository subOrderStatusRepository) {
        this.orderStatusRepository = orderStatusRepository;
        this.subOrderStatusRepository = subOrderStatusRepository;
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


        if(bikerUpdateDTO.getStatus() == CLOSESTATUS){
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

            CompletedOrderDTO completedOrderDTO = new CompletedOrderDTO(bikerUpdateDTO.getOrderId(), order.getStudentId(), toMacDTOList);

            /**
             * send CompletedOrderDTO to Mcmaster
             */


        }
    }

    public void statusSorderUpdate(BikerSorderUpdateDTO bikerSorderUpdateDTO) {
        SubOrderInfo subOrderInfo = subOrderStatusRepository.findById(bikerSorderUpdateDTO.getSubOrderId()).orElse(null);
        if(subOrderInfo == null) {
            throw new SubOrderNotFoundException(bikerSorderUpdateDTO.getSubOrderId());
        }
        subOrderInfo.setStatus(bikerSorderUpdateDTO.getStatus());

    }
}
