package com.LuckyStar.MenuSystem.business;

import com.LuckyStar.MenuSystem.business.entities.Menu;
import com.LuckyStar.MenuSystem.dto.MenuDeletionRequest;
import com.LuckyStar.MenuSystem.dto.MenuRegistrationRequest;
import com.LuckyStar.MenuSystem.ports.MenuManagement;
import com.LuckyStar.MenuSystem.ports.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MenuManager implements MenuManagement {
    private MenuRepository menuRepository;

    @Autowired
    public MenuManager(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    private boolean exists(Menu menu) {
        if (!Objects.isNull(menu.getId())){
            return menuRepository.findById(menu.getId()).isPresent();
        }
        return menuRepository.findByResId(menu.getResId()).size() > 0;
    }

    @Override
    public Menu add(MenuRegistrationRequest food) {
        Menu menu = new Menu(food.getResId(), food.getName(), food.getPrice(), food.getDescription(), food.getPicture_url());
        if(exists(menu)) {
            throw new IllegalArgumentException("food Already exists");
        }
        Menu saved = menuRepository.save(menu);

        return saved;
    }

    @Override
    public void delete(MenuDeletionRequest del) {

    }
}
