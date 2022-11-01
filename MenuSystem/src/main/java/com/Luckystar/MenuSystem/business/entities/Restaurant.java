package com.LuckyStar.MenuSystem.business.entities;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Restaurant {
    @Id
    private String id;
    @NonNull
    private String user_id;
    @NonNull
    private String name;
    private String logo_url;
}
