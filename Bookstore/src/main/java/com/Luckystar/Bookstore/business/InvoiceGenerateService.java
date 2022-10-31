package com.Luckystar.Bookstore.business;

import com.Luckystar.Bookstore.dto.InvoiceDTO;
import com.Luckystar.Bookstore.ports.IInvoiceGenerateService;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceGenerateService implements IInvoiceGenerateService {

  @Autowired
  JPAQueryFactory jpaQueryFactory;

  @Override
  public List<InvoiceDTO> findInvoice() {
//    QBillBook qBillBook=QBillBook.billBook;
//    QItem qItem=QItem.item;
//
////    JPAQuery<Tuple> jpaQuery=jpaQueryFactory.select(qBillBook.Id,)
//    List<Tuple> tuples=jpaQueryFactory.select(qBillBook.Id,qBillBook.amount,qBillBook.itemId,qBillBook.date,
//            qBillBook.isChecked,qItem.itemName,qItem.price)
//        .innerJoin(qBillBook)
//        .on(qItem.id.eq(qBillBook.itemId))
//        .fetch();
    return null;
  }
}
