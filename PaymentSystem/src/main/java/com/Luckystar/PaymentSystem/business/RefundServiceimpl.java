package com.Luckystar.PaymentSystem.business;

import com.Luckystar.PaymentSystem.ports.IRefundService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RefundServiceimpl implements IRefundService {

    @Override
    public void refundTranscation(String transactionId) {
        log.info("send transactionId: " + transactionId + " to bank");
        log.info("sent");
    }
}
