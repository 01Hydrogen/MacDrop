package com.Luckystar.Delievery.business.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "DROP_LOCATION")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@Getter
@Setter
public class DropLocationEntity {

    /**
     * 自动生成ID
     */
    @Id
    @Column(name = "ID",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    private String id;

    /**
     * 取餐地点名
     */
    @Column(name = "LOCATION_NAME")
    private String locationName;
}
