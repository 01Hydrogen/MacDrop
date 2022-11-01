package com.Luckystar.Bookstore.ports;

import com.Luckystar.Bookstore.business.entities.Item;
import java.util.List;

public interface IItemFinderService {
  List<Item> findAll();
  Item findOneByItemName(String itemName);
}
