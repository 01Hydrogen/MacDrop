package com.Luckystar.PaymentSystem.adapters.advices;

import com.Luckystar.PaymentSystem.business.InvoiceRejectedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class InvoiceRejectedAdvice {
    @ResponseBody
    @ExceptionHandler(InvoiceRejectedException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    String invoiceRejectedHandler(InvoiceRejectedException ex) {
        return ex.getMessage();
    }
}
