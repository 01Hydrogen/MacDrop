package com.Luckystar.user.business.entity;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class UserEntity {
    @Id
    @Column(name = "id",nullable = false,length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    private String id;
}
