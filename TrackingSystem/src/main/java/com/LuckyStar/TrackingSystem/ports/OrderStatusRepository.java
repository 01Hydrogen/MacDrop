package com.LuckyStar.TrackingSystem.ports;

import com.LuckyStar.TrackingSystem.business.entities.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderStatusRepository extends JpaRepository<OrderInfo, String> {
    List<OrderInfo> findAllByStatus(int status);
    List<OrderInfo> findAllByBikerId(String biker_id);
}
