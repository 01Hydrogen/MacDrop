package com.Luckystar.PaymentSystem.ports;

import com.Luckystar.PaymentSystem.dto.RefundDTO;

public interface IRefundService {
    Double refundTranscation(RefundDTO refundDTO);
}
