package com.LuckyStar.TrackingSystem.adapters;

import com.LuckyStar.TrackingSystem.business.entities.SubOrderInfo;
import com.LuckyStar.TrackingSystem.ports.ISubOrderFinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(produces = "application/json")
public class SubOrderController {
    private final String ENDPOINT = "/suborder";

    private final ISubOrderFinderService iSubOrderFinderService;

    @Autowired
    public SubOrderController(ISubOrderFinderService iSubOrderFinderService) {
        this.iSubOrderFinderService = iSubOrderFinderService;
    }


    @GetMapping(ENDPOINT)
    public List<SubOrderInfo> findAllSubOrder(){
        return iSubOrderFinderService.findAll();
    }

    /**
     * Biker will find the details of the order he selected by calling this API
     * @param order_id
     * @return
     */
    @GetMapping(ENDPOINT + "/order" + "/{order_id}")
    public List<SubOrderInfo> findAllSubOrdersByOrderId(@PathVariable String order_id){
        return iSubOrderFinderService.findAllSubOrdersByOrderId(order_id);
    }
}
