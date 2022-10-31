package com.Luckystar.Bookstore.ports;

import com.Luckystar.Bookstore.business.entities.BillBook;

import java.time.LocalDate;

import java.util.List;

public interface IBillBookFinderService {

  List<BillBook> findAllByChecked(boolean checked);
  List<BillBook> findAllByDateBetween(LocalDate startDate, LocalDate endDate);


}
