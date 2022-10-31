package com.Luckystar.PaymentSystem.ports;

import com.Luckystar.PaymentSystem.dto.CartInvoiceDTO;
import com.Luckystar.PaymentSystem.dto.InvoiceDTO;

public interface ICartInvoiceService {
    public CartInvoiceDTO createInvoice(InvoiceDTO cart);
}
