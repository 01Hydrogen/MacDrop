package com.Luckystar.Bookstore.ports;

import com.Luckystar.Bookstore.business.entities.Item;
import com.Luckystar.Bookstore.dto.ItemDTO;

public interface IItemLogService {
    Item logItem(ItemDTO itemDTO);

}
