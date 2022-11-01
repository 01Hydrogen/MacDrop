package com.Luckystar.Bookstore.business;

import com.Luckystar.Bookstore.business.entities.Item;
import com.Luckystar.Bookstore.exception.ItemNotFoundException;
import com.Luckystar.Bookstore.ports.IItemFinderService;
import com.Luckystar.Bookstore.ports.IItemRepository;
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
