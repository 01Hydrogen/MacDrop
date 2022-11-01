package com.LuckyStar.TrackingSystem.business;

import com.LuckyStar.TrackingSystem.business.entities.OrderInfo;
import com.LuckyStar.TrackingSystem.ports.IOrderFinderService;
import com.LuckyStar.TrackingSystem.ports.OrderStatusRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderFinderServiceimpl implements IOrderFinderService {
    private OrderStatusRepository orderStatusRepository;
    private final Integer PENDING = 1;

    @Autowired
    public OrderFinderServiceimpl(OrderStatusRepository orderStatusRepository) {
        this.orderStatusRepository = orderStatusRepository;
    }

    @Override
    public List<OrderInfo> findAllByStatus(int status) {

        return orderStatusRepository.findAllByStatus(status);
    }


    @Override
    public List<OrderInfo> findAllByBikerId(String biker_id) {
        return orderStatusRepository.findAllByBikerId(biker_id);
    }

    @Override
    public List<OrderInfo> findAll() {
        return orderStatusRepository.findAll();
    }
}
