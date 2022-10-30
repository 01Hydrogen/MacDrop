//package com.Luckystar.Delievery.business.entity;
//
//import lombok.Getter;
//import lombok.Setter;
//import org.hibernate.annotations.GenericGenerator;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Entity
//@Table(name = "DELIVERY_TABLE")
//@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
//@Getter
//@Setter
//public class DeliveryEntity {
//
//    /**
//     * 自动生成ID
//     */
//    @Id
//    @Column(name = "ID", length = 32)
//    @GeneratedValue(generator = "jpa-uuid")
//    private String id;
//
//    /**
//     * 学生ID
//     */
//    @Column(name = "STUDENT_ID",length = 32)
//    private String studentId;
//
//    /**
//     * 骑手ID
//     */
//    @Column(name = "BIKER_ID",length = 32)
//    private String bikerId;
//
//    /**
//     * 订单创建时间
//     */
//    @Column(name = "CREATE_TIME")
//    private Date createTime;
//
//    /**
//     * 订单送达时间
//     */
//    @Column(name = "DELIVERED_TIME")
//    private Date deliveredTime;
//
//    /**
//     * 订单总金额
//     */
//    @Column(name = "TOTAL_PRICE")
//    private  double totalPrice;
//
//    /**
//     * 订单状态
//     * 0=pending,1=paid,2=cooking,3=cooked,4=taken,5=delivered
//     */
//    @Column(name = "STATUS")
//    private int status;
//
//    /**
//     * 购物车内容，由menu_id+,+amount+|拼接而成
//     */
//    @Column(name = "CART_ITEMS",length = 1000)
//    private String cartItems;
//
//    /**
//     * 送达地点
//     */
//    @Column(name = "DELIVERED_LOCATION")
//    private String deliverLocation;
//
//    /**
//     * 送达时间
//     */
//    @Column(name = "DELIVERED_TIME")
//    private String deliverTimeSlot;
//}
