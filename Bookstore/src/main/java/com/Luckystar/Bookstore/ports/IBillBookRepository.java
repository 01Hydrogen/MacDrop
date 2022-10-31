package com.Luckystar.Bookstore.ports;

import com.Luckystar.Bookstore.business.entities.BillBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IBillBookRepository extends JpaRepository<BillBook, String> {


  List<BillBook> findAllByChecked(Boolean checked);
  List<BillBook> findAllByDateBetween(LocalDate startDate, LocalDate endDate);

}
