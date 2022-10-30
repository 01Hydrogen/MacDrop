package com.LuckyStar.Bookstore.business;

import com.LuckyStar.Bookstore.business.entities.BillBook;
import com.LuckyStar.Bookstore.ports.IBillBookFinderService;
import com.LuckyStar.Bookstore.ports.IBillBookRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class BillBookFinderService implements IBillBookFinderService {
  private final IBillBookRepository repository;

  public BillBookFinderService(IBillBookRepository repository) {
    this.repository = repository;
  }


  @Override
  public List<BillBook> findAllByChecked(boolean checked) {
    // JpaRepository link database with entity
    //Jpa method looks for items in database with isChecked
    List<BillBook> result = repository.findAllByChecked(checked);
    if (result.size() == 0) {
      throw new BillNotFoundException();
    }
    else {
      return result;
    }
  }

  @Override
  public List<BillBook> findAllByDateBetween(LocalDate startDate, LocalDate endDate) {
    List<BillBook> result = repository.findAllByDateBetween(startDate, endDate);
    if (result.size() == 0) {
      throw new BillNotFoundException();
    }
    else {
      return result;
    }
  }
}
