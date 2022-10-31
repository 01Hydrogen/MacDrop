package com.Luckystar.Delievery.adaptor;

import com.Luckystar.Delievery.dto.AddDropLocationDTO;
import com.Luckystar.Delievery.dto.DropLocationStatusDTO;
import com.Luckystar.Delievery.dto.ModifyDropLocationDTO;
import com.Luckystar.Delievery.dto.UseDropLocationDTO;
import com.Luckystar.Delievery.exception.DropLocationCRUDException;
import com.Luckystar.Delievery.ports.IDropLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
            throw e;
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
            throw e;
        }
    }

    /**
     * 修改取餐点
     * @param modifyDropLocationDTO
     * @return
     */
    @RequestMapping(value = "/modifyDropLocation",method = RequestMethod.PUT)
    @ResponseBody
    public String ModifyDropLocation(ModifyDropLocationDTO modifyDropLocationDTO) throws DropLocationCRUDException{
        try {
            dropLocationService.ModifyDropLocation(modifyDropLocationDTO);
            return "Drop location modified";
        }catch (DropLocationCRUDException e){
            throw e;
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }


    /**
     * 查询所有drop location
     * @return
     * @throws DropLocationCRUDException
     */
    @RequestMapping(value = "/findDropLocation", method = RequestMethod.GET)
    @ResponseBody
    public List<AddDropLocationDTO> FindDropLocation() throws DropLocationCRUDException {
        try {
            return dropLocationService.FindDropLocation();
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 查询当前各drop location及其使用状况
     * @return
     * @throws DropLocationCRUDException
     */
    @RequestMapping(value = "/getDropLocation",method = RequestMethod.GET)
    @ResponseBody
    public List<DropLocationStatusDTO> GetDropLocationStatus() throws DropLocationCRUDException {
        try {
            return dropLocationService.GetDropLocationStatus();
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 选定drop location使用量+1，在order生成时调用
     * @return
     */
    @RequestMapping(value = "/useDropLocation",method = RequestMethod.PUT)
    @ResponseBody
    public String UseDropLocation(UseDropLocationDTO useDropLocationDTO){
        try {
            boolean result=dropLocationService.UseDropLocation(useDropLocationDTO);
            if(result){
                return "Successful";
            }else {
                return "Failure";
            }
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 手动重新创建dropLocationStatusBeans，服务器崩溃时使用
     * @return
     */
    @RequestMapping(value = "/testFunction",method = RequestMethod.POST)
    @ResponseBody
    public String testFunction(){
        dropLocationService.function();
        return null;
    }
}

