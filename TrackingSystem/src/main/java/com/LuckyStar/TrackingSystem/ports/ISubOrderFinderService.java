package com.LuckyStar.TrackingSystem.ports;

import com.LuckyStar.TrackingSystem.business.entities.SubOrderInfo;

import java.util.List;

public interface ISubOrderFinderService {
    List<SubOrderInfo> findAll();

    List<SubOrderInfo> findAllSubOrdersByOrderId(String order_id);
}
