package com.Luckystar.Delievery.business;

import com.Luckystar.Delievery.business.entity.DropLocationEntity;
import com.Luckystar.Delievery.business.entity.QDropLocationEntity;
import com.Luckystar.Delievery.dto.AddDropLocationDTO;
import com.Luckystar.Delievery.dto.DropLocationStatusDTO;
import com.Luckystar.Delievery.dto.ModifyDropLocationDTO;
import com.Luckystar.Delievery.dto.UseDropLocationDTO;
import com.Luckystar.Delievery.exception.DropLocationCRUDException;
import com.Luckystar.Delievery.ports.DropLocationRepository;
import com.Luckystar.Delievery.ports.IDropLocationService;
import com.Luckystar.Delievery.utils.DropLocationStatusBean;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class DropLocationServiceImpl implements IDropLocationService {

    @Autowired
    private DropLocationRepository dropLocationRepository;

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    private List<DropLocationStatusBean> dropLocationStatusBeans;

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
    @Transactional
    public boolean DelDropLocation(AddDropLocationDTO addDropLocationDTO) throws DropLocationCRUDException {
        String locationName=addDropLocationDTO.getLocationName();
        try {
            //若不存在该地点则禁止删除
            boolean exists=dropLocationRepository.existsByLocationName(addDropLocationDTO.getLocationName());
            if(!exists){
                throw new DropLocationCRUDException("Drop Location does not exist!");
            }else {
                dropLocationRepository.deleteByLocationName(locationName);
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
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
    @Transactional
    public boolean ModifyDropLocation(ModifyDropLocationDTO modifyDropLocationDTO) throws DropLocationCRUDException{

        try {
            QDropLocationEntity qDropLocationEntity=QDropLocationEntity.dropLocationEntity;
            Predicate predicate=null;
            predicate= ExpressionUtils.and(predicate,qDropLocationEntity.locationName.eq(modifyDropLocationDTO.getOldLocationName()));
            long result=jpaQueryFactory.update(qDropLocationEntity)
                    .set(qDropLocationEntity.locationName,modifyDropLocationDTO.getLocationName())
                    .where(predicate)
                    .execute();
            if(result>0){
                return true;
            }else {
                throw new DropLocationCRUDException("Selected location does not exist");
            }

        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
//        DropLocationEntity dropLocationEntity=new DropLocationEntity();
//        dropLocationEntity.setId(modifyDropLocationDTO.getOldLocationName());
//        dropLocationEntity.setLocationName(modifyDropLocationDTO.getLocationName());
//        try {
//            dropLocationRepository.save(dropLocationEntity);
//            return true;
//        }catch (Exception e) {
//            throw e;
//        }
    }

    /**
     * 查询取餐点
     * @return
     * @throws DropLocationCRUDException
     */
    @Override
    public List<AddDropLocationDTO> FindDropLocation() throws DropLocationCRUDException {
        List<DropLocationEntity> dropLocationEntities=dropLocationRepository.findAll();
        List<AddDropLocationDTO> dropLocationDTOS=new ArrayList<>();
        for (DropLocationEntity d:dropLocationEntities
             ) {
            AddDropLocationDTO addDropLocationDTO=new AddDropLocationDTO();
            addDropLocationDTO.setLocationName(d.getLocationName());
            dropLocationDTOS.add(addDropLocationDTO);
        }
        return dropLocationDTOS;
    }

    /**
     * 查询取餐点状态
     * @return
     * @throws DropLocationCRUDException
     */
    @Override
    public List<DropLocationStatusDTO> GetDropLocationStatus() throws DropLocationCRUDException {
        List<DropLocationStatusDTO> dropLocationStatusDTOS=new ArrayList<>();
        for (DropLocationStatusBean bean:dropLocationStatusBeans
             ) {
            DropLocationStatusDTO dropLocationStatusDTO=new DropLocationStatusDTO();
            dropLocationStatusDTO.setLocationName(bean.getLocationName());
            dropLocationStatusDTO.setLocationStatus(bean.getTimeSlot());
            dropLocationStatusDTOS.add(dropLocationStatusDTO);
        }
        return dropLocationStatusDTOS;
    }

    /**
     * 选定drop location使用量+1，在order生成时调用
     * @param useDropLocationDTO
     * @return
     */
    @Override
    public boolean UseDropLocation(UseDropLocationDTO useDropLocationDTO) {
        try {
            String dropLocation=useDropLocationDTO.getLocationName();
            int index=useDropLocationDTO.getTimeSlotIndex();
            for (DropLocationStatusBean bean:dropLocationStatusBeans
            ) {
                //若名称匹配，则对应时间段使用量+1
                if (bean.getLocationName().equals(dropLocation)){
                    bean.getTimeSlot()[index]++;
                    return true;
                }
            }
            return false;
        }catch (Exception e){
            throw e;
        }

    }


    /**
     * 每天中午十点创建DropLocationStatus对象
     */
    @Scheduled(cron = "0 0 10 * * ?")
//    @Scheduled(cron = "*/5 * * * * ?")
    public void function(){
        //重新创建List
        this.dropLocationStatusBeans=new ArrayList<>();
        //查表获取所有drop location
        List<DropLocationEntity> dropLocationEntities=dropLocationRepository.findAll();
        for (DropLocationEntity dropLocationEntity:dropLocationEntities
             ) {
            this.dropLocationStatusBeans.add(new DropLocationStatusBean(dropLocationEntity.getLocationName()));
        }
    }

}
