package com.LuckyStar.TrackingSystem.ports;

import com.LuckyStar.TrackingSystem.business.entities.OrderInfo;
import com.LuckyStar.TrackingSystem.business.entities.SubOrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubOrderStatusRepository extends JpaRepository<SubOrderInfo, String> {

}
