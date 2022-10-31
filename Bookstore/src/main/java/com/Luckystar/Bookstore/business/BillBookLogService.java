package com.Luckystar.Bookstore.business;

import com.Luckystar.Bookstore.business.entities.*;
import com.Luckystar.Bookstore.dto.BillBookDTO;
import com.Luckystar.Bookstore.ports.IBillBookLogService;
import com.Luckystar.Bookstore.ports.IBillBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class BillBookLogService implements IBillBookLogService {
  private IBillBookRepository repository;

  @Autowired
  public BillBookLogService(IBillBookRepository repository){
    this.repository = repository;
  }

  @Override
  public BillBook log(BillBookDTO billBookDTO) {
    BillBook anBill = new BillBook
        (billBookDTO.getItemId(), billBookDTO.getAmount(),
            billBookDTO.isChecked(), billBookDTO.getDate());

    BillBook saved = repository.save(anBill);
    return saved;
  }
}
