package com.Luckystar.UserManagement.ports;

import com.Luckystar.UserManagement.dto.UserDTO;

public interface IUserMDDConsumeService {

    boolean MDDConsume(UserDTO userDTO);
}
