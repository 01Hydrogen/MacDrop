package com.Luckystar.MenuSystem.ports;

import com.Luckystar.MenuSystem.business.entities.Menu;
import com.Luckystar.MenuSystem.dto.MenuRegistrationRequest;

public interface MenuManagement {
    /**
     * add new food to menu
     * @param food
     * @return
     */
    Menu add(MenuRegistrationRequest food);

    /**
     * delete a food from menu
     * @param food
     */
    void delete(String food);

    /**
     * delete the menu of a restaurant, if the restaurant is closed
     */
    void deleteByResId(String id);

}
