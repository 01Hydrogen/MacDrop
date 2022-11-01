package com.Luckystar.Bookstore.business;

import com.Luckystar.Bookstore.business.entities.Item;
import com.Luckystar.Bookstore.dto.BillBookDTO;
import com.Luckystar.Bookstore.ports.IBillBookLogService;
import com.Luckystar.Bookstore.ports.IBillBookRepository;
import com.Luckystar.Bookstore.business.entities.BillBook;
import com.Luckystar.Bookstore.ports.IItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class BillBookLogService implements IBillBookLogService {
  private IBillBookRepository repository;
  private IItemRepository itemRepository;

  @Autowired
  public BillBookLogService(IBillBookRepository repository,IItemRepository itemRepository)
  {
    this.repository = repository;
   this. itemRepository = itemRepository;
  }

  @Override
  public BillBook log(BillBookDTO billBookDTO) {
    //using itemId which passed in by billBookDTO
    //to find Item object
    String itemId = billBookDTO.getItemId();
    Optional<Item> target = itemRepository.findById(itemId);
    BillBook anBill = new BillBook
        (target.get(), billBookDTO.getAmount(),
            billBookDTO.isChecked(), billBookDTO.getDate());

    BillBook saved = repository.save(anBill);
    return saved;
  }
}
