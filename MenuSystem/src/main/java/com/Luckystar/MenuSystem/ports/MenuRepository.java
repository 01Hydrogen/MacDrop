package com.Luckystar.MenuSystem.ports;

import com.Luckystar.MenuSystem.business.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, String> {

    List<Menu> findByResId(String res_id);
    List<Menu> findByResIdAndName(String res_id, String name);
    void deleteById(String id);
    void deleteAllByResId(String user_id);
}
