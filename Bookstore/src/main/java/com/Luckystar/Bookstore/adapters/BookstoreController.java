package com.LuckyStar.Bookstore.adapters;

import com.LuckyStar.Bookstore.business.BillBookLogService;
import com.LuckyStar.Bookstore.business.entities.BillBook;
import com.LuckyStar.Bookstore.dto.InvoiceDTO;
import com.LuckyStar.Bookstore.ports.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import com.LuckyStar.Bookstore.dto.BillBookDTO;
import com.LuckyStar.Bookstore.business.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(produces = "application/json")
public class BookstoreController {

  private static final String ENDPOINT = "Bookstore";
  private final IItemFinderService itemRegistry;
  private final IBillBookLogService logService;
  private final IBillBookFinderService billRegistry;
  private final IInvoiceGenerateService invoiceGenrator;

  @Autowired
  public BookstoreController(IItemFinderService itemRegistry, IBillBookLogService logService,
                             IBillBookFinderService billRegistry,IInvoiceGenerateService invoiceGenrator){
    this.itemRegistry = itemRegistry;
    this.logService = logService;
    this.billRegistry = billRegistry;
    this.invoiceGenrator = invoiceGenrator;

  }

  @GetMapping(ENDPOINT+"/itemFindAll"+"/{item}")
  public List<Item> findAll() {
    return itemRegistry.findAll();
  }

  @GetMapping(ENDPOINT+"/itemFindByName"+"/{findByItemName}")
  public Item findByItemName(@RequestParam(value="itemName") String itemName) {
    return itemRegistry.findOneByItemName(itemName);
  }

  @GetMapping(ENDPOINT+"/billFindByChecked"+"/{findByChecked}")
  public List<BillBook> findAllByChecked(@RequestParam boolean checked){
    return billRegistry.findAllByChecked(checked);
  }

  @GetMapping(ENDPOINT+"/billFindByDate"+"/{findByDate}")
  public List<BillBook> findAllByDateBetween(@RequestParam
                                                 LocalDate startDate, LocalDate endDate){
    return billRegistry.findAllByDateBetween(startDate, endDate);
  }

  @PostMapping(ENDPOINT+"/{log}")
  public BillBook log(@RequestBody BillBookDTO billBookDTO){
    return logService.log(billBookDTO);
  }

  @GetMapping(ENDPOINT+"/invoice")
  public List<InvoiceDTO> findInvoice() {
    return invoiceGenrator.findInvoice();
  }
}
