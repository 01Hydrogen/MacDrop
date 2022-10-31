package com.Luckystar.MenuSystem.business.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor @RequiredArgsConstructor
@Getter @Setter
@ToString
public class Menu {
    @Id
    private String id;
    @NonNull @Column(name = "Res_Id")
    private String resId;
    @NonNull
    private String name;
    private String description;
    private String picture_url;

}
