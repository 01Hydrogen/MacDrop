package com.Luckystar.UserManagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDTO {

    private String id;

    private String macId;

    private String username;

    private int type;

    private String password;

    private String emailAddress;

    private double MMD;
}
