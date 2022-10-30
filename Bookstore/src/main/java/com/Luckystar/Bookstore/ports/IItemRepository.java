package com.Luckystar.Bookstore.ports;

import com.Luckystar.Bookstore.business.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IItemRepository extends JpaRepository<Item, String> {
  List<Item> findOneByItemName(String itemName);
}
