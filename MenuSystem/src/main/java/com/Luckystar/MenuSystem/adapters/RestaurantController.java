package com.Luckystar.MenuSystem.adapters;

import com.Luckystar.MenuSystem.business.entities.Restaurant;
import com.Luckystar.MenuSystem.dto.RestaurantInfoDTO;
import com.Luckystar.MenuSystem.ports.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(produces = "application/json")
public class RestaurantController {

    private static final String ENDPOINT = "restuarant";

    private final IRestaurantService iRestaurantService;

    @Autowired
    public RestaurantController(IRestaurantService iRestaurantService) {
        this.iRestaurantService = iRestaurantService;
    }

    @GetMapping(ENDPOINT+"/findAll")
    public List<Restaurant> findAllRestaurant(){
        return iRestaurantService.findAllRestaurant();
    }

    @PostMapping(ENDPOINT + "/register")
    public String register(@RequestBody RestaurantInfoDTO restaurantInfoDTO){
        return iRestaurantService.register(restaurantInfoDTO);
    }
}
