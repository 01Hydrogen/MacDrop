package com.Luckystar.Bookstore.ports;

import com.Luckystar.Bookstore.dto.InvoiceDTO;

import java.util.List;

public interface IInvoiceGenerateService {
  List<InvoiceDTO> findInvoice();
}
