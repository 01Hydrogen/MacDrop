package com.LuckyStar.Bookstore.ports;

import com.LuckyStar.Bookstore.business.entities.BillBook;
import com.LuckyStar.Bookstore.dto.BillBookDTO;

public interface IBillBookLogService {
  /**
   * 记账
   * @param accountBookDTO
   * @return
   */
  BillBook log(BillBookDTO accountBookDTO);
}
