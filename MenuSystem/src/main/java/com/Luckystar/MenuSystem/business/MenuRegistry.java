package com.LuckyStar.MenuSystem.business;

import com.LuckyStar.MenuSystem.business.entities.Menu;
import com.LuckyStar.MenuSystem.ports.MenuRepository;
import com.LuckyStar.MenuSystem.ports.MenuFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuRegistry implements MenuFinder {

    private final MenuRepository repository;

    @Autowired
    public MenuRegistry(MenuRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Menu> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Menu> findByResId(String res_id) {
        return repository.findByResId(res_id);
    }


}
