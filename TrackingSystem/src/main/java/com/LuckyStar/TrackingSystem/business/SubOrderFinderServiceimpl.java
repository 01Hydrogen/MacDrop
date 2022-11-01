package com.LuckyStar.TrackingSystem.business;

import com.LuckyStar.TrackingSystem.business.entities.OrderInfo;
import com.LuckyStar.TrackingSystem.business.entities.SubOrderInfo;
import com.LuckyStar.TrackingSystem.ports.ISubOrderFinderService;
import com.LuckyStar.TrackingSystem.ports.OrderStatusRepository;
import com.LuckyStar.TrackingSystem.ports.SubOrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubOrderFinderServiceimpl implements ISubOrderFinderService {

    private final SubOrderStatusRepository subOrderStatusRepository;
    private final OrderStatusRepository orderStatusRepository;

    @Autowired
    public SubOrderFinderServiceimpl(SubOrderStatusRepository subOrderStatusRepository, OrderStatusRepository orderStatusRepository) {
        this.subOrderStatusRepository = subOrderStatusRepository;
        this.orderStatusRepository = orderStatusRepository;
    }

    @Override
    public List<SubOrderInfo> findAll() {
        return subOrderStatusRepository.findAll();
    }

    @Override
    public List<SubOrderInfo> findAllSubOrdersByOrderId(String order_id) {
        OrderInfo orderInfo = orderStatusRepository.findById(order_id).orElseThrow(null);
        return orderInfo.getSubOrderInfo();
    }


}
