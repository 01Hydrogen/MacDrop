package com.LuckyStar.Bookstore.business;

import com.LuckyStar.Bookstore.business.entities.*;
import com.LuckyStar.Bookstore.dto.BillBookDTO;
import com.LuckyStar.Bookstore.ports.IBillBookLogService;
import com.LuckyStar.Bookstore.ports.IBillBookRepository;
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
