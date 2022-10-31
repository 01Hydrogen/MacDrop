package com.Luckystar.PaymentSystem.business;

import com.Luckystar.PaymentSystem.dto.CartInvoiceDTO;
import com.Luckystar.PaymentSystem.dto.InvoiceDTO;
import com.Luckystar.PaymentSystem.ports.ICartInvoiceService;
import org.springframework.stereotype.Service;

@Service
public class CartInvoiceServiceimpl implements ICartInvoiceService {

    @Override
    public CartInvoiceDTO createInvoice(InvoiceDTO cart) {
        /**
         * assume 10% of the payment will be rejected
         */
        if(Math.random()*100 < 10) {
            throw new InvoiceRejectedException(cart.getUserId());
        }



        return new CartInvoiceDTO(cart.getTotalPrice()*1.13, cart.getUserId(), "Success");
    }
}
