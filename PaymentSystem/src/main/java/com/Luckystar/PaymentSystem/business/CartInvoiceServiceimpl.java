package com.Luckystar.PaymentSystem.business;

import com.Luckystar.PaymentSystem.dto.InvoiceResponseDTO;
import com.Luckystar.PaymentSystem.dto.InvoiceDTO;
import com.Luckystar.PaymentSystem.ports.ICartInvoiceService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CartInvoiceServiceimpl implements ICartInvoiceService {

    @Override
    public InvoiceResponseDTO createInvoice(InvoiceDTO cart) {
        /**
         * assume 10% of the payment will be rejected
         */
        if(Math.random()*100 < 10) {
            throw new InvoiceRejectedException(cart.getUserId());
        }

        /**
         * generate a fake random UUID as the transactionId received from bank
         */
        UUID uuid = UUID.randomUUID();
        return new InvoiceResponseDTO(cart.getTotalPrice()*1.13, cart.getUserId(), "Success", uuid.toString());
    }
}
