package com.Luckystar.Bookstore.adapters;

import com.Luckystar.Bookstore.business.entities.BillBook;
import com.Luckystar.Bookstore.dto.InvoiceDTO;
import com.Luckystar.Bookstore.dto.ItemDTO;
import com.Luckystar.Bookstore.ports.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import com.Luckystar.Bookstore.dto.BillBookDTO;
import com.Luckystar.Bookstore.business.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(produces = "application/json")
public class BookstoreController {

  private static final String ENDPOINT = "Bookstore";
  private final IItemFinderService itemRegistry;
  private final IItemLogService itemLogService;
  private final IBillBookLogService logService;
  private final IBillBookFinderService billRegistry;
  private final IInvoiceGenerateService invoiceGenerator;

  private List<InvoiceDTO> invoice;

  @Autowired
  public BookstoreController(IItemFinderService itemRegistry,IItemLogService itemLogService, IBillBookLogService logService,
                             IBillBookFinderService billRegistry,IInvoiceGenerateService invoiceGenerator){
    this.itemRegistry = itemRegistry;
    this.itemLogService = itemLogService;
    this.logService = logService;
    this.billRegistry = billRegistry;
    this.invoiceGenerator = invoiceGenerator;

  }

  @Autowired
  McMasterAdminClientProxy mcMasterAdminClientProxy;


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
//
//  @GetMapping(ENDPOINT+"/invoice")
//  public List<InvoiceDTO> generateInvoice() {
//    return invoiceGenerator.generateInvoice();
//  }


//  @Scheduled(cron = "*/5 * * * * *")
  @RequestMapping(value = ENDPOINT+"/scheduledInvoice",method = RequestMethod.POST)
  public void scheduledInvoice(){
      Double invoice = (Double) invoiceGenerator.generateInvoice().get(1);
      mcMasterAdminClientProxy.savePrice(invoice);
      System.out.println(invoice);
  }

  @GetMapping(ENDPOINT+"/{invoice}")
  public List getInvoice(){
    return invoiceGenerator.generateInvoice();
  }

  @PostMapping(ENDPOINT + "logItem "+"/{logItem}")
  public Item logItem(@RequestBody ItemDTO itemDTO) {
    return itemLogService.logItem(itemDTO);
  }
}
