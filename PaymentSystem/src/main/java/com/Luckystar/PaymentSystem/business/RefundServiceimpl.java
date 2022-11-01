package com.Luckystar.PaymentSystem.business;

import com.Luckystar.PaymentSystem.dto.RefundDTO;
import com.Luckystar.PaymentSystem.ports.IRefundService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RefundServiceimpl implements IRefundService {

    @Override
    public Double refundTranscation(RefundDTO refundDTO) {
        log.info("send transactionId: " + refundDTO.getTransactionId() + " to bank");
        log.info("sent");
        return refundDTO.getTotalPrice()*1.13;
    }
}
