package com.LuckyStar.TrackingSystem.ports;

import com.LuckyStar.TrackingSystem.business.entities.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusRepository extends JpaRepository<OrderInfo, String> {

}
