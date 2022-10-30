package com.LuckyStar.Bookstore.ports;

import com.LuckyStar.Bookstore.business.entities.BillBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IBillBookRepository extends JpaRepository<BillBook, String> {


  List<BillBook> findAllByChecked(Boolean checked);
  List<BillBook> findAllByDateBetween(LocalDate startDate, LocalDate endDate);

}
