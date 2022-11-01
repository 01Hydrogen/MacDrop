package com.LuckyStar.TrackingSystem.ports;

import com.LuckyStar.TrackingSystem.business.entities.OrderInfo;
import com.querydsl.core.types.Order;

import java.util.List;

public interface IOrderFinderService {
    List<OrderInfo> findAllByStatus(int status);
    List<OrderInfo> findAllByResId(String res_id);
    List<OrderInfo> findAllByBikerId(String biker_id);
    List<OrderInfo> findAll();
}
