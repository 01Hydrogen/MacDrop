package com.LuckyStar.Cart.adapters;

import com.LuckyStar.Cart.dto.menuDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="menu-service")
public interface MenuClientProxy {

    String ENDPOINT = "/menu";
    @GetMapping(ENDPOINT + "/restaurant" +"/{res_id}")
    public List<menuDTO> getAllFoodFromRes(@PathVariable String res_id);

    @GetMapping(ENDPOINT)
    public List<menuDTO> findAll();

    @GetMapping(ENDPOINT + "/restaurants" +"/{res_ids}")
    public List<menuDTO> findByResIds(@PathVariable String res_ids);
}
