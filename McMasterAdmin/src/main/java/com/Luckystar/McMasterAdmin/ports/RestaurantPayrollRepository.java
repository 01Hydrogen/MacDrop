package com.Luckystar.McMasterAdmin.ports;

import com.Luckystar.McMasterAdmin.business.entity.RestaurantPayrollEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantPayrollRepository extends JpaRepository<RestaurantPayrollEntity,String> {
}
