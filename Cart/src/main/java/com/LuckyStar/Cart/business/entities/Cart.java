package com.LuckyStar.Cart.business.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Cart {
    @Id @GeneratedValue(generator = "jpa-uuid")
    private String id;
    @NonNull @Column(name = "user_Id")
    private String userId;
    @Column(name = "menu_Id")
    private String menuId;

    private Integer amount;
}



