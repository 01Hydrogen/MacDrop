package com.LuckyStar.MenuSystem.ports;

import com.LuckyStar.MenuSystem.business.entities.Menu;
import com.LuckyStar.MenuSystem.dto.MenuDeletionRequest;
import com.LuckyStar.MenuSystem.dto.MenuRegistrationRequest;

public interface MenuManagement {
    Menu add(MenuRegistrationRequest food);
    void delete(MenuDeletionRequest food);
}
