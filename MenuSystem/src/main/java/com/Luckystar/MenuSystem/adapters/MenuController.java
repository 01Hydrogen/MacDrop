package com.Luckystar.MenuSystem.adapters;

import com.Luckystar.MenuSystem.business.entities.Menu;
import com.Luckystar.MenuSystem.dto.MenuRegistrationRequest;
import com.Luckystar.MenuSystem.ports.MenuFinder;
import com.Luckystar.MenuSystem.ports.MenuManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(produces = "application/json")
public class MenuController {

    private static final String ENDPOINT = "/menu";
    private final MenuFinder registry;
    private final MenuManagement manager;

    @Autowired
    public MenuController(MenuFinder registry, MenuManagement manager) {
        this.registry = registry;
        this.manager = manager;
    }

    /**
     * get all food info from all restaurant menu
     * @return
     */
    @GetMapping(ENDPOINT+"/findAllRegisteredFood")
    public List<Menu> findAll(){
        return registry.findAll();
    }

    /**
     * get all the food info from a restaurant menu
     * @param res_id
     * @return
     */
    @GetMapping(ENDPOINT + "/restaurant" + "/{res_id}")
    public List<Menu> findByResId(@PathVariable String res_id){
        return registry.findByResId(res_id);
    }

    /**
     * get all menu info given list of restaurant id
     * @param res_ids
     * @return
     */
    @GetMapping(ENDPOINT + "/restaurants" +"/{res_ids}")
    public List<Menu> findByResIds(@PathVariable String res_ids){
        List<Menu> combinedResMenu = new ArrayList<>();
        String[] res_id = res_ids.split(",");
        for(String s: res_id){
            combinedResMenu.addAll(registry.findByResId(s));
        }
        return combinedResMenu;
    }

    /**
     * add a food to a restaurant menu
     * @param food
     * @return
     */
    @PostMapping(ENDPOINT)
    public Menu Add(@RequestBody MenuRegistrationRequest food){
        return manager.add(food);
    }

    /**
     * delete a food from menu
     * @param id
     */
    @DeleteMapping(ENDPOINT + "/{id}")
    public void deleteFood(@PathVariable String id){
        manager.delete(id);
    }

    /**
     * delete the menu of a restaurant, if the restaurant is closed
     * @param res_id
     */
    @Transactional
    @DeleteMapping(ENDPOINT + "/res" + "/{res_id}")
    public void deleteMenu(@PathVariable String res_id){
        manager.deleteByResId(res_id);
    }
}
