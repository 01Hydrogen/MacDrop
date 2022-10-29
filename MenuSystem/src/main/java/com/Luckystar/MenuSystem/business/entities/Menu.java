package com.LuckyStar.MenuSystem.business.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@NoArgsConstructor @RequiredArgsConstructor
@Getter @Setter
@ToString
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Menu {
    @Id @GeneratedValue(generator = "jpa-uuid",strategy = GenerationType.AUTO)
    private String id;
    @NonNull @Column(name = "Res_Id")
    private String resId;
    @NonNull
    private String name;
    @NonNull
    private Double price;
    private String description;
    private String picture_url;

    public Menu(@NonNull String resId, @NonNull String name, @NonNull Double price, String description, String picture_url) {
        this.resId = resId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.picture_url = picture_url;
    }
}
