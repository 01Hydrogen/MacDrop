package com.Luckystar.PaymentSystem.business;

import com.Luckystar.PaymentSystem.dto.PayrollDTO;
import com.Luckystar.PaymentSystem.ports.IPayrollService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PayrollServiceimpl implements IPayrollService {
    public void pay(PayrollDTO payrollDTO) {
        /**
         * Send to bank with all the payroll info.
         */
        log.info("send out payslip to targetId: " + payrollDTO.getTargetId());
        log.info("with total amount of revenue: " + payrollDTO.getRevenue());
    }
}
