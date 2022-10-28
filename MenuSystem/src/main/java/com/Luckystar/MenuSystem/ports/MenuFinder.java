package com.LuckyStar.MenuSystem.ports;

import com.LuckyStar.MenuSystem.business.entities.Menu;

import java.util.List;

public interface MenuFinder {
    List<Menu> findAll();

}
