package com.LuckyStar.Cart.business.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor

@Getter
@Setter
@ToString
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Cart {
    public Cart(String id, @NonNull String userId, String menuId, Integer amount) {
        this.id = id;
        this.userId = userId;
        this.menuId = menuId;
        this.amount = amount;
    }

    @Id @GeneratedValue(generator = "jpa-uuid")
    private String id;
    @NonNull @Column(name = "user_Id")
    private String userId;
    @NonNull @Column(name = "res_Id")
    private String resId;
    @Column(name = "menu_Id")
    private String menuId;

    private Integer amount;


}



