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
         * generate fake random UUIDs as the transactionId received from bank
         * we first count how many uuid we need to generate by counting how many res_id in the Res_id field.
         */
        int length = cart.getRes_id().split("/").length;
        String transactionIds = "";
        for(int i = 0; i < length; ++i){
            transactionIds += UUID.randomUUID().toString() + "/";
        }
        return new InvoiceResponseDTO(cart.getTotalPrice()*1.13, cart.getUserId(), "Success", transactionIds);
    }
}
