package com.Luckystar.Delievery.ports;

import com.Luckystar.Delievery.dto.AddDropLocationDTO;
import com.Luckystar.Delievery.dto.DropLocationStatusDTO;
import com.Luckystar.Delievery.dto.ModifyDropLocationDTO;
import com.Luckystar.Delievery.dto.UseDropLocationDTO;
import com.Luckystar.Delievery.exception.DropLocationCRUDException;

import java.util.List;

public interface IDropLocationService {

    //添加取餐点
    boolean AddDropLocation(AddDropLocationDTO addDropLocationDTO) throws DropLocationCRUDException;
    //删除取餐点
    boolean DelDropLocation(AddDropLocationDTO addDropLocationDTO) throws DropLocationCRUDException;
    //修改取餐点
    boolean ModifyDropLocation(ModifyDropLocationDTO modifyDropLocationDTO) throws DropLocationCRUDException;
    //查询取餐点
    List<AddDropLocationDTO> FindDropLocation() throws DropLocationCRUDException;
    //查询取餐点状态
    List<DropLocationStatusDTO> GetDropLocationStatus() throws DropLocationCRUDException;
    //选定drop location使用量+1，在order生成时调用
    boolean UseDropLocation(UseDropLocationDTO useDropLocationDTO);
    //测试方法
    void function();
}
