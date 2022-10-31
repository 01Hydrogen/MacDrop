package com.Luckystar.MenuSystem.ports;

import com.Luckystar.MenuSystem.business.entities.Menu;

import java.util.List;

public interface MenuFinder {
    List<Menu> findAll();

}
