package com.Luckystar.UserManagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrentUserDTO {

    public CurrentUserDTO(String id, String username){
        this.id=id;
        this.username=username;
    }

    private String id;
    private String username;
}
