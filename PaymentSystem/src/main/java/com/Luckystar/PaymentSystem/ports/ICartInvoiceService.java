package com.Luckystar.PaymentSystem.ports;

import com.Luckystar.PaymentSystem.dto.InvoiceResponseDTO;
import com.Luckystar.PaymentSystem.dto.InvoiceDTO;

public interface ICartInvoiceService {
    public InvoiceResponseDTO createInvoice(InvoiceDTO cart);
}
