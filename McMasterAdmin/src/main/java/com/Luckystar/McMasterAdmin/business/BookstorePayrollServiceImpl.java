package com.Luckystar.McMasterAdmin.business;

import com.Luckystar.McMasterAdmin.business.entity.BookstorePayrollEntity;
import com.Luckystar.McMasterAdmin.ports.BookstorePayrollRepository;
import com.Luckystar.McMasterAdmin.ports.IBookstorePayrollService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BookstorePayrollServiceImpl implements IBookstorePayrollService {

    @Autowired
    BookstorePayrollRepository bookstorePayrollRepository;

    @Autowired
    JPAQueryFactory jpaQueryFactory;

    /**
     * 接收bookstore发来的金额，并储存
     * @param price
     */
    @Override
    public void savePrice(Double price) {
        BookstorePayrollEntity bookstorePayrollEntity=new BookstorePayrollEntity();
        bookstorePayrollEntity.setPaid(false);
        bookstorePayrollEntity.setDate(new Date());
        bookstorePayrollEntity.setRevenue(price);
        bookstorePayrollRepository.save(bookstorePayrollEntity);
    }


}
