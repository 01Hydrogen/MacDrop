package com.Luckystar.MenuSystem.business;

import com.Luckystar.MenuSystem.business.entities.Menu;
import com.Luckystar.MenuSystem.ports.MenuRepository;
import com.Luckystar.MenuSystem.ports.MenuFinder;
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
}
