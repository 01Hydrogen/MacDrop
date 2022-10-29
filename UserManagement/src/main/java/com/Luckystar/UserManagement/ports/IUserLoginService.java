package com.Luckystar.UserManagement.ports;

import com.Luckystar.UserManagement.dto.UserDTO;

public interface IUserLoginService {

    UserDTO Login(UserDTO userDTO) throws Exception;
}
