package com.Luckystar.MenuSystem.business;

import com.Luckystar.MenuSystem.business.entities.Menu;
import com.Luckystar.MenuSystem.dto.MenuDeletionRequest;
import com.Luckystar.MenuSystem.dto.MenuRegistrationRequest;
import com.Luckystar.MenuSystem.ports.MenuManagement;
import com.Luckystar.MenuSystem.ports.MenuRepository;
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
        return menuRepository.findByResIdAndName(menu.getResId(), menu.getName()).size() > 0;
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
    public void delete(String id) {
        if(menuRepository.findById(id) == null){
            throw new FoodNotFoundException(id);
        }
        menuRepository.deleteById(id);
    }

    @Override
    public void deleteByResId(String res_id) {
        if(menuRepository.findByResId(res_id).size() < 1){
            throw new MenuNotFoundException(res_id);
        }
        menuRepository.deleteAllByResId(res_id);
    }
}
