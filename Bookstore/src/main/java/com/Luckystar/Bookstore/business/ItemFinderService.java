package com.LuckyStar.Bookstore.business;

import com.LuckyStar.Bookstore.business.entities.Item;
import com.LuckyStar.Bookstore.ports.IItemFinderService;
import com.LuckyStar.Bookstore.ports.IItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemFinderService implements IItemFinderService {
  private final IItemRepository repository;

  @Autowired
  public ItemFinderService(IItemRepository repository){
    this.repository = repository;
  }

  @Override
  public List<Item> findAll() {
    return repository.findAll();
  }

  @Override
  public Item findOneByItemName(String itemName) {
    List<Item> result = repository.findOneByItemName(itemName);
    if (result.size() == 0) {
      throw new ItemNotFoundException(itemName);
    }
    else {
      return result.get(0);
    }
  }
}
