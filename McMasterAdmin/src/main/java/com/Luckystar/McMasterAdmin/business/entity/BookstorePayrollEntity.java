package com.Luckystar.McMasterAdmin.business.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BOOKSTORE_PAYROLL")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@Getter
@Setter
public class BookstorePayrollEntity {

    /**
     * 自动生成ID
     */
    @Id
    @Column(name = "ID",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    private String id;

    /**
     * 转账金额
     */
    @Column(name = "REVENUE")
    private double revenue;

    /**
     * 转账日期
     */
    @Column(name = "DATE")
    private Date date;

    /**
     * 是否已结算
     */
    @Column(name = "PAID")
    private boolean paid;
}
