package com.LuckyStar.MenuSystem.ports;

import com.LuckyStar.MenuSystem.business.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, String> {

    List<Menu> findByResId(String res_id);
}
