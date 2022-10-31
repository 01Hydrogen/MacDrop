package com.Luckystar.MenuSystem.business;

import com.Luckystar.MenuSystem.ports.MenuManagement;
import com.Luckystar.MenuSystem.ports.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuManager implements MenuManagement {
    private MenuRepository menuRepository;

    @Autowired
    public MenuManager(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }



}
