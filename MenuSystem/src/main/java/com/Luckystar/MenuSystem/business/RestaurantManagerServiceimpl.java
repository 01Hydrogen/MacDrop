package com.Luckystar.MenuSystem.business;

import com.Luckystar.MenuSystem.business.entities.Restaurant;
import com.Luckystar.MenuSystem.dto.RestaurantInfoDTO;
import com.Luckystar.MenuSystem.ports.IRestaurantService;
import com.Luckystar.MenuSystem.ports.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantManagerServiceimpl implements IRestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantManagerServiceimpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurant> findAllRestaurant() {
        return restaurantRepository.findAll();
    }

    @Override
    public String register(RestaurantInfoDTO restaurantInfoDTO) {

        Restaurant restaurant = new Restaurant(restaurantInfoDTO.getUserId(), restaurantInfoDTO.getName(), restaurantInfoDTO.getLogUrl());
        Restaurant saved = restaurantRepository.save(restaurant);
        return "Restaurant: " + restaurantInfoDTO.getName() + "register success";
    }
}
