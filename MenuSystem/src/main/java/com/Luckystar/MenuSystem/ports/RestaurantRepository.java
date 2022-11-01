package com.Luckystar.MenuSystem.ports;

import com.Luckystar.MenuSystem.business.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, String> {

}
