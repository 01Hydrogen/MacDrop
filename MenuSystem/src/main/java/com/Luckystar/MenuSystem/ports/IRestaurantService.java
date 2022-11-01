package com.Luckystar.MenuSystem.ports;

import com.Luckystar.MenuSystem.business.entities.Restaurant;
import com.Luckystar.MenuSystem.dto.RestaurantInfoDTO;

import java.util.List;

public interface IRestaurantService {
    List<Restaurant> findAllRestaurant();
    String register(RestaurantInfoDTO restaurantInfoDTO);
}
