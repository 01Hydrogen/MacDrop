package com.LuckyStar.TrackingSystem.adapters;

import com.LuckyStar.TrackingSystem.business.entities.OrderInfo;
import com.LuckyStar.TrackingSystem.dto.BikerUpdateDTO;
import com.LuckyStar.TrackingSystem.dto.CartCheckOutDTO;
import com.LuckyStar.TrackingSystem.dto.OrderRejectedDTO;
import com.LuckyStar.TrackingSystem.dto.ResUpdateDTO;
import com.LuckyStar.TrackingSystem.ports.IBikerUpdateService;
import com.LuckyStar.TrackingSystem.ports.IOrderCreateService;
import com.LuckyStar.TrackingSystem.ports.IOrderFinderService;
import com.LuckyStar.TrackingSystem.ports.IResUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(produces = "application/json")
public class TrackingController {

    private final String ENDPOINT = "/order";


    private final IOrderCreateService iOrderCreateService;
    private final IBikerUpdateService iBikerUpdateService;
    private final IResUpdateService iResUpdateService;
    private final IOrderFinderService iOrderFinderService;
    @Autowired
    public TrackingController(IOrderCreateService iOrderCreateService, IBikerUpdateService iBikerUpdateService, IResUpdateService iResUpdateService, IOrderFinderService iOrderFinderService) {
        this.iOrderCreateService = iOrderCreateService;
        this.iBikerUpdateService = iBikerUpdateService;
        this.iResUpdateService = iResUpdateService;
        this.iOrderFinderService = iOrderFinderService;
    }

    @GetMapping(ENDPOINT + "/all")
    public List<OrderInfo> findAll(){
        return iOrderFinderService.findAll();
    }

    /**
     * Biker can find all pending orders by calling this API
     * @param status
     * @return
     */
    @GetMapping(ENDPOINT + "/status" + "/{status}")
    public List<OrderInfo> findAllByStatus(@PathVariable Integer status){
        return iOrderFinderService.findAllByStatus(status);
    }

    /**
     * Biker can find all the orders that he selected by calling this API
     * @param biker_id
     * @return
     */
    @GetMapping(ENDPOINT + "/biker" +"/{biker_id}")
    public List<OrderInfo> findAllBiker(@PathVariable String biker_id){
        return iOrderFinderService.findAllByBikerId(biker_id);
    }

    /**
     * cart checkOut process,  create an Order
     * @param cartCheckOutDTO
     * @return
     */
    @PostMapping(ENDPOINT + "/created")
    public String createOrder(@RequestBody CartCheckOutDTO cartCheckOutDTO){
        iOrderCreateService.orderCreate(cartCheckOutDTO);
        return "Order Created";
    }

    /**
     * when biker finished all the subOrders of his Order, he will update the Order(not subOrder) status here
     * @param bikerUpdateDTO
     * @return
     */
    @PutMapping(ENDPOINT + "/bikerUpdate")
    public String bikerUpdateStatus(@RequestBody BikerUpdateDTO bikerUpdateDTO){
        iBikerUpdateService.statusUpdate(bikerUpdateDTO);
        return "Status Update";
    }

    /**
     * restaurant rejceted a SubOrder,
     * for now, if one restaurant reject the SubOrder, the Big Order will get rejected entirely
     * @param orderRejectedDTO
     * @return
     */
    @PutMapping(ENDPOINT + "/orderReject")
    public String orderRejected(@RequestBody OrderRejectedDTO orderRejectedDTO){
        return iResUpdateService.orderRejected(orderRejectedDTO);
    }
}
