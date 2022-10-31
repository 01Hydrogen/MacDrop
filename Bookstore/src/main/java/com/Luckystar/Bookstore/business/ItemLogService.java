package com.Luckystar.Bookstore.business;

import com.Luckystar.Bookstore.business.entities.BillBook;
import com.Luckystar.Bookstore.business.entities.Item;
import com.Luckystar.Bookstore.dto.ItemDTO;
import com.Luckystar.Bookstore.ports.IItemLogService;
import com.Luckystar.Bookstore.ports.IItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemLogService implements IItemLogService {
    @Autowired
    IItemRepository repository;

    public ItemLogService(IItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public Item logItem(ItemDTO itemDTO) {
        //to find Item object
        String itemId = itemDTO.getId();
        Optional<Item> target = repository.findById(itemId);
        Item anItem = new Item(itemDTO.getId(), itemDTO.getItemName(),
                        itemDTO.getPrice());

        Item saved = repository.save(anItem);
        return saved;
    }
}
