package com.Luckystar.McMasterAdmin.ports;

import com.Luckystar.McMasterAdmin.business.entity.BookstorePayrollEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookstorePayrollRepository extends JpaRepository<BookstorePayrollEntity,String> {
}
