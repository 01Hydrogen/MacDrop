package com.Luckystar.Delievery.ports;

import com.Luckystar.Delievery.dto.AddDropLocationDTO;
import com.Luckystar.Delievery.dto.ModifyDropLocationDTO;
import com.Luckystar.Delievery.exception.DropLocationCRUDException;

public interface IDropLocationService {

    //添加取餐点
    boolean AddDropLocation(AddDropLocationDTO addDropLocationDTO) throws DropLocationCRUDException;
    //删除取餐点
    boolean DelDropLocation(AddDropLocationDTO addDropLocationDTO) throws DropLocationCRUDException;
    //修改取餐点
    boolean ModifyDropLocation(ModifyDropLocationDTO modifyDropLocationDTO) throws DropLocationCRUDException;
}
