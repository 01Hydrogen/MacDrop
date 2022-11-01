package com.Luckystar.MenuSystem.business.entities;


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
public class Restaurant {
    public Restaurant(@NonNull String userId, @NonNull String name, String logoUrl) {
        this.userId = userId;
        this.name = name;
        this.logoUrl = logoUrl;
    }

    @Id @GeneratedValue(generator = "jpa-uuid")
    private String id;
    @NonNull @Column(name = "user_id")
    private String userId;
    @NonNull
    private String name;
    @Column(name = "logo_url")
    private String logoUrl;
}
