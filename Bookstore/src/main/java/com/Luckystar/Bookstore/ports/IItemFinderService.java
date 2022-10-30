package com.LuckyStar.Bookstore.ports;

import com.LuckyStar.Bookstore.business.entities.Item;
import java.util.List;

public interface IItemFinderService {
  List<Item> findAll();
  Item findOneByItemName(String itemName);
}
