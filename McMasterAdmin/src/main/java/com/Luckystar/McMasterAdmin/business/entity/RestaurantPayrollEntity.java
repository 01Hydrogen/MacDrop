package com.Luckystar.McMasterAdmin.business.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "RESTAURANT_PAYROLL")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@Getter
@Setter
public class RestaurantPayrollEntity {

    /**
     * 自动生成ID
     */
    @Id
    @Column(name = "ID",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    private String id;

    /**
     * 订单ID
     */
    @Column(name = "ORDER_ID")
    private String orderId;

    /**
     * 菜品单价
     */
    @Column(name = "PRICE")
    private double price;

    /**
     * 菜名
     */
    @Column(name = "MENU_NAME")
    private String menuName;

    /**
     * 餐厅ID
     */
    @Column(name = "RESTAURANT_ID")
    private String restaurantId;

    /**
     * 点餐学生ID
     */
    @Column(name = "STUDENT_ID")
    private String studentId;

    /**
     * 菜品数量
     */
    @Column(name = "AMOUNT")
    private int amount;

    /**
     * 该订单的该菜品的总价
     */
    @Column(name = "TOTAL_PRICE")
    private double totalPrice;

    /**
     * 是否已审批
     */
    @Column(name = "APPROVED")
    private boolean approved;

}
