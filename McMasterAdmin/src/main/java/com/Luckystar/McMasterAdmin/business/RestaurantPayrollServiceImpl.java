package com.Luckystar.McMasterAdmin.business;

import com.Luckystar.McMasterAdmin.business.entity.RestaurantPayrollEntity;
import com.Luckystar.McMasterAdmin.dto.MenuInfoDTO;
import com.Luckystar.McMasterAdmin.dto.RestaurantPayrollDTO;
import com.Luckystar.McMasterAdmin.ports.IRestaurantPayrollService;
import com.Luckystar.McMasterAdmin.ports.RestaurantPayrollRepository;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantPayrollServiceImpl implements IRestaurantPayrollService {

    @Autowired
    RestaurantPayrollRepository restaurantPayrollRepository;

    /**
     * 接收从Tracking传来的订单
     * @param restaurantPayrollDTO
     * @return
     */
    @Override
    public boolean createPayroll(RestaurantPayrollDTO restaurantPayrollDTO) {
        String orderId=restaurantPayrollDTO.getOrder_id();
        String studentId=restaurantPayrollDTO.getStudent_id();
        List<MenuInfoDTO> menuInfoDTOList=restaurantPayrollDTO.getMenuInfoDTOList();
        try {
            //遍历menuInfoDTOList生成记录
            for (MenuInfoDTO m:menuInfoDTOList
            ) {
                RestaurantPayrollEntity restaurantPayrollEntity=new RestaurantPayrollEntity();
                //写入RestaurantPayrollDTO内容
                restaurantPayrollEntity.setOrderId(orderId);
                restaurantPayrollEntity.setStudentId(studentId);
                //写入MenuInfoDTO内容
                restaurantPayrollEntity.setRestaurantId(m.getRes_id());
                restaurantPayrollEntity.setPrice(m.getPrice());
                restaurantPayrollEntity.setMenuName(m.getMenu_name());
                restaurantPayrollEntity.setAmount(m.getAmount());
                //存入数据库
                restaurantPayrollRepository.save(restaurantPayrollEntity);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
        return true;
    }

    /**
     * 向payment service付款
     * @return
     */
    @Override
    public List payPrice() {
        //先
        return null;
    }

    @Override
    public List sendEmailToRestaurant() {
        return null;
    }
}
