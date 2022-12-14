package com.Luckystar.Bookstore.ports;

import com.Luckystar.Bookstore.business.entities.BillBook;
import com.Luckystar.Bookstore.dto.BillBookDTO;

public interface IBillBookLogService {
  /**
   * 记账
   * @param billBookDTO
   * @return
   */
  BillBook log(BillBookDTO billBookDTO);
}
