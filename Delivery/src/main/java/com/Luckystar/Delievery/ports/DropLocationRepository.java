package com.Luckystar.Delievery.ports;

import com.Luckystar.Delievery.business.entity.DropLocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DropLocationRepository extends JpaRepository<DropLocationEntity,String> {
    boolean existsByLocationName(String name);
    void deleteByLocationName(String name);
}
