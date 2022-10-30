package com.Luckystar.Delievery.business;

import com.Luckystar.Delievery.business.entity.DropLocationEntity;
import com.Luckystar.Delievery.dto.AddDropLocationDTO;
import com.Luckystar.Delievery.dto.ModifyDropLocationDTO;
import com.Luckystar.Delievery.exception.DropLocationCRUDException;
import com.Luckystar.Delievery.ports.DropLocationRepository;
import com.Luckystar.Delievery.ports.IDropLocationService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DropLocationServiceImpl implements IDropLocationService {

    @Autowired
    private DropLocationRepository dropLocationRepository;

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    /**
     * 添加取餐点
     * @param addDropLocationDTO
     * @return
     * @throws DropLocationCRUDException
     */
    @Override
    public boolean AddDropLocation(AddDropLocationDTO addDropLocationDTO) throws DropLocationCRUDException {
        DropLocationEntity dropLocationEntity=new DropLocationEntity();
        dropLocationEntity.setLocationName(addDropLocationDTO.getLocationName());
        try {
            //若已存在该地点则禁止添加
            boolean exists=dropLocationRepository.existsByLocationName(addDropLocationDTO.getLocationName());
            if(exists){
                throw new DropLocationCRUDException("Drop Location already exists!");
            }else {
                dropLocationRepository.save(dropLocationEntity);
                return true;
            }
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
    @Override
    public boolean DelDropLocation(AddDropLocationDTO addDropLocationDTO) throws DropLocationCRUDException {
        String locationName=addDropLocationDTO.getLocationName();
        try {
            //若不存在该地点则禁止删除
            boolean exists=dropLocationRepository.existsByLocationName(addDropLocationDTO.getLocationName());
            if(!exists){
                throw new DropLocationCRUDException("Drop Location does not exist!");
            }else {
                dropLocationRepository.deleteById(locationName);
                return true;
            }
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 修改取餐点
     * @param modifyDropLocationDTO
     * @return
     * @throws DropLocationCRUDException
     */
    @Override
    public boolean ModifyDropLocation(ModifyDropLocationDTO modifyDropLocationDTO){
        DropLocationEntity dropLocationEntity=new DropLocationEntity();
        dropLocationEntity.setId(modifyDropLocationDTO.getId());
        dropLocationEntity.setLocationName(modifyDropLocationDTO.getLocationName());
        try {
            dropLocationRepository.save(dropLocationEntity);
            return true;
        }catch (Exception e) {
            throw e;
        }
    }


}
