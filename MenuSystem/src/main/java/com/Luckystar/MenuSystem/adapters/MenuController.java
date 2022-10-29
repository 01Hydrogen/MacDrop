package com.LuckyStar.MenuSystem.adapters;

import com.LuckyStar.MenuSystem.business.entities.Menu;
import com.LuckyStar.MenuSystem.dto.MenuRegistrationRequest;
import com.LuckyStar.MenuSystem.ports.MenuFinder;
import com.LuckyStar.MenuSystem.ports.MenuManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(ENDPOINT)
    public List<Menu> findAll(){
        return registry.findAll();
    }

    @PostMapping(ENDPOINT)
    public Menu Add(@RequestBody MenuRegistrationRequest food){
        return manager.add(food);
    }
}
