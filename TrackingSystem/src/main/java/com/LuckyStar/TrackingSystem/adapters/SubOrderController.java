package com.LuckyStar.TrackingSystem.adapters;

import com.LuckyStar.TrackingSystem.business.entities.SubOrderInfo;
import com.LuckyStar.TrackingSystem.dto.BikerSorderUpdateDTO;
import com.LuckyStar.TrackingSystem.dto.OrderRejectedDTO;
import com.LuckyStar.TrackingSystem.dto.ResUpdateDTO;
import com.LuckyStar.TrackingSystem.ports.IBikerUpdateService;
import com.LuckyStar.TrackingSystem.ports.IResUpdateService;
import com.LuckyStar.TrackingSystem.ports.ISubOrderFinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(produces = "application/json")
public class SubOrderController {
    private final String ENDPOINT = "/suborder";

    private final ISubOrderFinderService iSubOrderFinderService;
    private final IBikerUpdateService iBikerUpdateService;
    private final IResUpdateService iResUpdateService;

    @Autowired
    public SubOrderController(ISubOrderFinderService iSubOrderFinderService, IBikerUpdateService iBikerUpdateService, IBikerUpdateService iBikerUpdateService1, IResUpdateService iResUpdateService) {
        this.iSubOrderFinderService = iSubOrderFinderService;
        this.iBikerUpdateService = iBikerUpdateService1;
        this.iResUpdateService = iResUpdateService;
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

    /**
     * find All subOrders of a restaurant
     * @param res_id
     * @return
     */
    @GetMapping(ENDPOINT + "/subOrder/res"+ "/{res_id}")
    public List<SubOrderInfo> findAllByResId(@PathVariable String res_id){
        return iSubOrderFinderService.findAllSubOrdersByresId(res_id);
    }

    /**
     * biker update subOrder status
     * @param bikerSorderUpdateDTO
     */
    @PutMapping(ENDPOINT + "/biker/update")
    public void bikerStatusUpdate(@RequestBody BikerSorderUpdateDTO bikerSorderUpdateDTO){
        iBikerUpdateService.statusSorderUpdate(bikerSorderUpdateDTO);
    }

    /**
     * restaurant update subOrder status
     * @param resUpdateDTO
     */
    @PutMapping(ENDPOINT + "/res/update")
    public String resStatusUpdate(@RequestBody ResUpdateDTO resUpdateDTO){
        return iResUpdateService.statusUpdate(resUpdateDTO);
    }

    /**
     * restaurant rejceted a SubOrder,
     * for now, if one restaurant reject the SubOrder, the Big Order will get rejected entirely
     * @param orderRejectedDTO
     * @return
     */
    @PutMapping(ENDPOINT + "/res/reject")
    public String orderRejected(@RequestBody OrderRejectedDTO orderRejectedDTO){
        return iResUpdateService.orderRejected(orderRejectedDTO);
    }

}
