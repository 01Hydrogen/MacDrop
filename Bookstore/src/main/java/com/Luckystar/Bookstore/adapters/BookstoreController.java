package com.Luckystar.Bookstore.adapters;

import com.Luckystar.Bookstore.business.entities.BillBook;
import com.Luckystar.Bookstore.dto.InvoiceDTO;
import com.Luckystar.Bookstore.business.entities.Item;
import com.Luckystar.Bookstore.dto.BillBookDTO;
import com.Luckystar.Bookstore.ports.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
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