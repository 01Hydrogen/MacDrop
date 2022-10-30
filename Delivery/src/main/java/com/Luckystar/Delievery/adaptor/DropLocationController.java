package com.Luckystar.Delievery.adaptor;

import com.Luckystar.Delievery.dto.AddDropLocationDTO;
import com.Luckystar.Delievery.dto.ModifyDropLocationDTO;
import com.Luckystar.Delievery.exception.DropLocationCRUDException;
import com.Luckystar.Delievery.ports.IDropLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/delivery")
public class DropLocationController {

    @Autowired
    private IDropLocationService dropLocationService;

    /**
     * 添加取餐点
     * @param addDropLocationDTO
     * @return
     * @throws DropLocationCRUDException
     */
    @RequestMapping(value = "/addDropLocation", method = RequestMethod.POST)
    @ResponseBody
    public String AddDropLocation(AddDropLocationDTO addDropLocationDTO) throws DropLocationCRUDException {
        try {
            dropLocationService.AddDropLocation(addDropLocationDTO);
            return "Drop Location added";
        }catch (DropLocationCRUDException dropLocationCRUDException){
            throw dropLocationCRUDException;
        }catch (Exception e){
            return "Unexpected exception";
        }
    }

    /**
     * 删除取餐点
     * @param addDropLocationDTO
     * @return
     * @throws DropLocationCRUDException
     */
    @RequestMapping(value = "/deleteDropLocation",method = RequestMethod.DELETE)
    @ResponseBody
    public String DeleteDropLocation(AddDropLocationDTO addDropLocationDTO) throws DropLocationCRUDException{
        try {
            dropLocationService.DelDropLocation(addDropLocationDTO);
            return "Drop Location deleted";
        }catch (DropLocationCRUDException dropLocationCRUDException){
            throw dropLocationCRUDException;
        }catch (Exception e){
            return "Unexpected exception";
        }
    }

    /**
     * 修改取餐点
     * @param modifyDropLocationDTO
     * @return
     */
    @RequestMapping(value = "/modifyDropLocation",method = RequestMethod.PUT)
    @ResponseBody
    public String ModifyDropLocation(ModifyDropLocationDTO modifyDropLocationDTO){
        try {
            dropLocationService.ModifyDropLocation(modifyDropLocationDTO);
            return "Drop location modified";
        }catch (Exception e){
            e.printStackTrace();
            return "Unexpected exception";
        }
    }

}
