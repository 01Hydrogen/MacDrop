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
     * Biker will call this API and find all pending orders
     * @param status
     * @return
     */
    @GetMapping(ENDPOINT + "/status" + "/{status}")
    public List<OrderInfo> findAllByStatus(@PathVariable Integer status){
        return iOrderFinderService.findAllByStatus(status);
    }
    @GetMapping(ENDPOINT+ "/res" + "/{res_id}")
    public List<OrderInfo> findAllByResId(@PathVariable String res_id){
        return iOrderFinderService.findAllByResId(res_id);
    }

    @GetMapping(ENDPOINT + "/biker" +"/{biker_id}")
    public List<OrderInfo> findAllBiker(@PathVariable String biker_id){
        return iOrderFinderService.findAllByBikerId(biker_id);
    }

    @PostMapping(ENDPOINT + "/created")
    public String createOrder(@RequestBody CartCheckOutDTO cartCheckOutDTO){
        iOrderCreateService.orderCreate(cartCheckOutDTO);
        return "Order Created";
    }

    @PutMapping(ENDPOINT + "/bikerUpdate")
    public String bikerUpdateStatus(@RequestBody BikerUpdateDTO bikerUpdateDTO){
        iBikerUpdateService.statusUpdate(bikerUpdateDTO);
        return "Status Update";
    }

    @PutMapping(ENDPOINT + "/orderReject")
    public String orderRejected(@RequestBody OrderRejectedDTO orderRejectedDTO){
        return iResUpdateService.orderRejected(orderRejectedDTO);
    }

    @PutMapping(ENDPOINT + "/resUpdate")
    public String resUpdateStatus(@RequestBody ResUpdateDTO resUpdateDTO){
        return iResUpdateService.statusUpdate(resUpdateDTO);
    }

}
