package com.Luckystar.Bookstore.ports;

import com.Luckystar.Bookstore.business.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IItemRepository extends JpaRepository<Item, String> {
  List<Item> findOneByItemName(String itemName);
}
