package com.Luckystar.McMasterAdmin.business;

import com.Luckystar.McMasterAdmin.business.entity.QRestaurantPayrollEntity;
import com.Luckystar.McMasterAdmin.business.entity.RestaurantPayrollEntity;
import com.Luckystar.McMasterAdmin.dto.*;
import com.Luckystar.McMasterAdmin.exception.NoBillsException;
import com.Luckystar.McMasterAdmin.ports.IRestaurantPayrollService;
import com.Luckystar.McMasterAdmin.ports.RestaurantPayrollRepository;
import com.google.gson.Gson;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@Service
public class RestaurantPayrollServiceImpl implements IRestaurantPayrollService {

    @Autowired
    RestaurantPayrollRepository restaurantPayrollRepository;

    @Autowired
    JPAQueryFactory jpaQueryFactory;

    /**
     * 接收从Tracking传来的订单
     * @param restaurantPayrollDTO
     * @return
     */
    @Override
    public boolean createPayroll(RestaurantPayrollDTO restaurantPayrollDTO) {
        String orderId=restaurantPayrollDTO.getOrderId();
        String studentId=restaurantPayrollDTO.getStudentId();
        List<MenuInfoDTO> menuInfoDTOList=restaurantPayrollDTO.getOrderInfo();
        try {
            //遍历menuInfoDTOList生成记录
            for (MenuInfoDTO m:menuInfoDTOList
            ) {
                RestaurantPayrollEntity restaurantPayrollEntity=new RestaurantPayrollEntity();
                //写入RestaurantPayrollDTO内容
                restaurantPayrollEntity.setOrderId(orderId);
                restaurantPayrollEntity.setStudentId(studentId);
                //写入MenuInfoDTO内容
                restaurantPayrollEntity.setRestaurantId(m.getResId());
                restaurantPayrollEntity.setPrice(m.getPrice());
                restaurantPayrollEntity.setMenuName(m.getMenuName());
                restaurantPayrollEntity.setAmount(m.getAmount());
                restaurantPayrollEntity.setTotalPrice(m.getPrice()*m.getAmount());
                restaurantPayrollEntity.setMDDChecked(false);
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
     * 向管理员显示各餐厅明细
     * @return
     */
    @Override
    public List<ShowOrderDetailsDTO> showOrderDetails() {
        QRestaurantPayrollEntity qRestaurantPayrollEntity=QRestaurantPayrollEntity.restaurantPayrollEntity;
        List<ShowOrderDetailsDTO> result=new ArrayList<>();
        //搜表，用hashset过滤出所有restaurant id
        HashSet<String> restaurantIdSet=new HashSet<>();
        List<RestaurantPayrollEntity> restaurantPayrollEntityList=restaurantPayrollRepository.findAll();
        for (RestaurantPayrollEntity r:restaurantPayrollEntityList
        ) {
            String restaurantId=r.getRestaurantId();
            restaurantIdSet.add(restaurantId);
        }
        //用id查出餐厅的所有条目
        Iterator it = restaurantIdSet.iterator();
        while (it.hasNext()){
            ShowOrderDetailsDTO showOrderDetailsDTO=new ShowOrderDetailsDTO();
            double totalPrice=0;
            List<OrderDetailsDTO> orderDetailsDTOList=new ArrayList<>();
            String restaurantId=(String) it.next();
            Predicate predicate=null;
            predicate= ExpressionUtils.and(predicate,qRestaurantPayrollEntity.approved.eq(false));
            predicate= ExpressionUtils.and(predicate,qRestaurantPayrollEntity.restaurantId.eq(restaurantId));
            List<RestaurantPayrollEntity> restaurantPayrollEntityList1=jpaQueryFactory.selectFrom(qRestaurantPayrollEntity)
                    .where(predicate)
                    .fetch();
            //计算价格，并写入餐厅订单信息
            for (RestaurantPayrollEntity r:restaurantPayrollEntityList1
            ) {
                OrderDetailsDTO orderDetailsDTO=new OrderDetailsDTO();
                orderDetailsDTO.setOrderId(r.getOrderId());
                orderDetailsDTO.setRestaurantId(r.getRestaurantId());
                orderDetailsDTO.setAmount(r.getAmount());
                orderDetailsDTO.setPrice(r.getPrice());
                orderDetailsDTOList.add(orderDetailsDTO);
                totalPrice+=r.getTotalPrice();
            }
            showOrderDetailsDTO.setRestaurantId(restaurantId);
            showOrderDetailsDTO.setOrderDetailsDTOList(orderDetailsDTOList);
            showOrderDetailsDTO.setTotalPrice(totalPrice);
            result.add(showOrderDetailsDTO);
        }
        return result;
    }


    /**
     * 向payment service付款
     * @return
     */
    @Override
    public PayPriceDTO payPrice(String restaurantId) throws NoBillsException {
        QRestaurantPayrollEntity qRestaurantPayrollEntity=QRestaurantPayrollEntity.restaurantPayrollEntity;
//        List<PayPriceDTO> result=new ArrayList<>();
        //先搜表，用hashset过滤出所有restaurant id，之后用id查出餐厅的所有条目，计算价格后加入list，返回到controller，call payment system
//        //搜表，用hashset过滤出所有restaurant id
//        HashSet<String> restaurantIdSet=new HashSet<>();
//        List<RestaurantPayrollEntity> restaurantPayrollEntityList=restaurantPayrollRepository.findAll();
//        for (RestaurantPayrollEntity r:restaurantPayrollEntityList
//             ) {
//            String restaurantId=r.getRestaurantId();
//            restaurantIdSet.add(restaurantId);
//        }
//        //用id查出餐厅的所有条目
//        Iterator it = restaurantIdSet.iterator();
//        while (it.hasNext()){
        PayPriceDTO payPriceDTO=new PayPriceDTO();
        double totalPrice=0;
//            String restaurantId=(String) it.next();
        Predicate predicate=null;
        predicate= ExpressionUtils.and(predicate,qRestaurantPayrollEntity.approved.eq(false));
        predicate= ExpressionUtils.and(predicate,qRestaurantPayrollEntity.restaurantId.eq(restaurantId));
        List<RestaurantPayrollEntity> restaurantPayrollEntityList1=jpaQueryFactory.selectFrom(qRestaurantPayrollEntity)
                    .where(predicate)
                    .fetch();
        //若该餐厅没有未结算的账单则抛出异常
        if (restaurantPayrollEntityList1.size()==0){
            throw new  NoBillsException("No bills to be paid");
        }
        //计算价格并加入list
        for (RestaurantPayrollEntity r:restaurantPayrollEntityList1
        ) {
            totalPrice+=r.getTotalPrice();
        }
        payPriceDTO.setTargetId(restaurantId);
        payPriceDTO.setRevenue(totalPrice);

//        result.add(payPriceDTO);
//       }
        return payPriceDTO;
    }

    /**
     * 向payment service付款后向餐厅发送明细
     * @param restaurantId
     * @return
     */
    @Override
    public EmailServiceDTO sendEmailToRestaurant(String restaurantId) {
        QRestaurantPayrollEntity qRestaurantPayrollEntity=QRestaurantPayrollEntity.restaurantPayrollEntity;
        List<OrderDetailsDTO> orderDetailsDTOList=new ArrayList<>();
        double totalPrice=0.0;
        ShowOrderDetailsDTO showOrderDetailsDTO=new ShowOrderDetailsDTO();

        Predicate predicate=null;
        predicate= ExpressionUtils.and(predicate,qRestaurantPayrollEntity.approved.eq(false));
        predicate= ExpressionUtils.and(predicate,qRestaurantPayrollEntity.restaurantId.eq(restaurantId));
        List<RestaurantPayrollEntity> restaurantPayrollEntityList1=jpaQueryFactory.selectFrom(qRestaurantPayrollEntity)
                .where(predicate)
                .fetch();
        for (RestaurantPayrollEntity r:restaurantPayrollEntityList1
        ) {
            OrderDetailsDTO orderDetailsDTO=new OrderDetailsDTO();
            orderDetailsDTO.setOrderId(r.getOrderId());
            orderDetailsDTO.setRestaurantId(r.getRestaurantId());
            orderDetailsDTO.setAmount(r.getAmount());
            orderDetailsDTO.setPrice(r.getPrice());
            orderDetailsDTOList.add(orderDetailsDTO);
            totalPrice+=r.getTotalPrice();
        }
        showOrderDetailsDTO.setOrderDetailsDTOList(orderDetailsDTOList);
        showOrderDetailsDTO.setTotalPrice(totalPrice);
        showOrderDetailsDTO.setRestaurantId(restaurantId);
        //封装并发送email
        Gson gson = new Gson();
        String body=gson.toJson(showOrderDetailsDTO);
//            gson.fromJson();
        EmailServiceDTO emailServiceDTO=new EmailServiceDTO();
        emailServiceDTO.setBody(body);
        emailServiceDTO.setFrom("McMaster Admin");
        emailServiceDTO.setTo(restaurantId);
        emailServiceDTO.setMessage("paid");
        return emailServiceDTO;
    }

    /**
     * 付款并发送邮件后所有被处理的订单paid改为true
     * @param restaurantId
     */
    @Override
    @Transactional
    public void setPaid(String restaurantId) {
        QRestaurantPayrollEntity qRestaurantPayrollEntity=QRestaurantPayrollEntity.restaurantPayrollEntity;
        Predicate predicate=null;
        predicate= ExpressionUtils.and(predicate,qRestaurantPayrollEntity.approved.eq(false));
        predicate= ExpressionUtils.and(predicate,qRestaurantPayrollEntity.restaurantId.eq(restaurantId));
        jpaQueryFactory.update(qRestaurantPayrollEntity)
                .set(qRestaurantPayrollEntity.approved,true)
                .where(predicate)
                .execute();
    }

    /**
     * 每周一早上8点向学生发放上周的MDD
     */
    @Override
    @Transactional
    public List<CalcMDDDTO> calcMDD() {
        QRestaurantPayrollEntity qRestaurantPayrollEntity=QRestaurantPayrollEntity.restaurantPayrollEntity;
        List<CalcMDDDTO> calcMDDDTOList=new ArrayList<>();
        //查询所有学生ID
        HashSet studentIdSet=new HashSet();
        List<RestaurantPayrollEntity> restaurantPayrollEntityList=jpaQueryFactory.selectFrom(qRestaurantPayrollEntity)
                .where(qRestaurantPayrollEntity.MDDChecked.eq(false))
                .fetch();
        for (RestaurantPayrollEntity r:restaurantPayrollEntityList
             ) {
            studentIdSet.add(r.getStudentId());
        }
        //按ID查找学生本周总金额和餐厅数
        Iterator it=studentIdSet.iterator();
        while (it.hasNext()){
            CalcMDDDTO calcMDDDTO=new CalcMDDDTO();
            HashSet<String> restaurantIds=new HashSet<>();
            int restaurantAmount=0;
            double totalPrice=0.0;
            double MDDRate=0;
            String studentId=(String) it.next();
            List<RestaurantPayrollEntity> r1=jpaQueryFactory.selectFrom(qRestaurantPayrollEntity)
                    .where(qRestaurantPayrollEntity.studentId.eq(studentId))
                    .fetch();
            //计算学生选择过的餐厅和总金额
            for (RestaurantPayrollEntity r:r1
                 ) {
                restaurantIds.add(r.getRestaurantId());
                //计算总消费金额
                totalPrice+=r.getTotalPrice();
            }
            //计算选择过的餐厅
            restaurantAmount=restaurantIds.size();
            //按餐厅数量算MDD转化率
            if(restaurantAmount>0){
                MDDRate=(restaurantAmount-1)*0.05;
            }
            if (MDDRate>=0.15){
                MDDRate=0.15;
            }
            //计算MDD金额
            calcMDDDTO.setMDD(MDDRate*totalPrice);
            calcMDDDTO.setId(studentId);
            calcMDDDTOList.add(calcMDDDTO);
        }
        //所有MDDChecked全部设置为已支付
        jpaQueryFactory.update(qRestaurantPayrollEntity)
                .set(qRestaurantPayrollEntity.MDDChecked,true)
                .execute();
        return calcMDDDTOList;
    }


}
