package com.LuckyStar.Bookstore.ports;

import com.LuckyStar.Bookstore.dto.InvoiceDTO;

import java.util.List;

public interface IInvoiceGenerateService {
  List<InvoiceDTO> findInvoice();
}
