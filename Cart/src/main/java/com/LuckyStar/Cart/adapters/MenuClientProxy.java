package com.LuckyStar.Cart.adapters;

import com.LuckyStar.Cart.dto.MenuDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="menu-service")
public interface MenuClientProxy {

    String ENDPOINT = "/menu";
    @GetMapping(ENDPOINT + "/restaurant" +"/{res_id}")
    public List<MenuDTO> getAllFoodFromRes(@PathVariable String res_id);

    @GetMapping(ENDPOINT)
    public List<MenuDTO> findAll();

    @GetMapping(ENDPOINT + "/restaurants" +"/{res_ids}")
    public List<MenuDTO> findByResIds(@PathVariable String res_ids);
}
