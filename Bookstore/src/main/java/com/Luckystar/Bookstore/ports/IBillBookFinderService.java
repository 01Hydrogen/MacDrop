package com.LuckyStar.Bookstore.ports;

import com.LuckyStar.Bookstore.business.entities.BillBook;

import java.time.LocalDate;

import java.util.List;

public interface IBillBookFinderService {

  List<BillBook> findAllByChecked(boolean checked);
  List<BillBook> findAllByDateBetween(LocalDate startDate, LocalDate endDate);


}
