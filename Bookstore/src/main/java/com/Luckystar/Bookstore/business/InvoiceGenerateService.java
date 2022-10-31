package com.Luckystar.Bookstore.business;

import com.Luckystar.Bookstore.adapters.McMasterAdminClientProxy;
import com.Luckystar.Bookstore.business.entities.BillBook;
import com.Luckystar.Bookstore.dto.InvoiceDTO;
import com.Luckystar.Bookstore.ports.IBillBookRepository;
import com.Luckystar.Bookstore.ports.IInvoiceGenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class InvoiceGenerateService implements IInvoiceGenerateService {
  @Autowired
  private final IBillBookRepository billBookRepository;



  public InvoiceGenerateService(IBillBookRepository billBookRepository){
    this.billBookRepository = billBookRepository;
  }

  @Override
  public List generateInvoice() {
    //retrieve all unchecked bills, prepare to put into dto
    List<BillBook> uncheckedBills = billBookRepository.findAllByChecked(false);
    List result = new ArrayList<>();
    //no new bills this week
    if (uncheckedBills.size() == 0) {
      throw new InvoiceNotFoundException();
    }
    else{
      //create invoiceDTO array, store each bill information in uncheckedBills
      List<InvoiceDTO> dtoList = new ArrayList<>();
      Double totalPrice = 0.0;
      for(int i = 0; i < uncheckedBills.size(); i++ ){
        BillBook currentBill = uncheckedBills.get(i);

        InvoiceDTO temp = new InvoiceDTO();
        temp.setItemId(currentBill.getItem().getId());
        temp.setItemName(currentBill.getItem().getItemName());
        temp.setAmount(currentBill.getAmount());
        temp.setPrice(currentBill.getItem().getPrice());

        dtoList.add(temp);

        totalPrice += currentBill.getAmount() * currentBill.getItem().getPrice();

      }
      result.add(dtoList);
      result.add(totalPrice);

      return result;
    }


  }
}


