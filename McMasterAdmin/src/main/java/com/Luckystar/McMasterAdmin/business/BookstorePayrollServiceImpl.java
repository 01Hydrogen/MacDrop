package com.Luckystar.McMasterAdmin.business;

import com.Luckystar.McMasterAdmin.business.entity.BookstorePayrollEntity;
import com.Luckystar.McMasterAdmin.business.entity.QBookstorePayrollEntity;
import com.Luckystar.McMasterAdmin.dto.PayPriceDTO;
import com.Luckystar.McMasterAdmin.ports.BookstorePayrollRepository;
import com.Luckystar.McMasterAdmin.ports.IBookstorePayrollService;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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

    /**
     * 审批并付款
     * @return
     */
    @Override
    public List<PayPriceDTO> approve() {
        List<PayPriceDTO> payPriceDTOList=new ArrayList<>();
        QBookstorePayrollEntity qBookstorePayrollEntity=QBookstorePayrollEntity.bookstorePayrollEntity;
        Predicate predicate=null;
        predicate= ExpressionUtils.and(predicate,qBookstorePayrollEntity.paid.eq(false));
        List<BookstorePayrollEntity> bookstorePayrollEntityList=jpaQueryFactory.selectFrom(qBookstorePayrollEntity)
                .where(predicate)
                .fetch();
        //查询所有未付款的订单并返回
        for (BookstorePayrollEntity b:bookstorePayrollEntityList
             ) {
            PayPriceDTO payPriceDTO=new PayPriceDTO();
            payPriceDTO.setRevenue(b.getRevenue());
            payPriceDTO.setTargetId("bookstore");
            payPriceDTOList.add(payPriceDTO);
        }
        //将所有未付款的订单设为已付款
        jpaQueryFactory.update(qBookstorePayrollEntity)
                .set(qBookstorePayrollEntity.paid,true)
                .execute();
        return payPriceDTOList;
    }


}
