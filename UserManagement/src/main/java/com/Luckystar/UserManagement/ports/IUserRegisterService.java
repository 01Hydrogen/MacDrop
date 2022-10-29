package com.Luckystar.UserManagement.ports;

import com.Luckystar.UserManagement.dto.UserDTO;

public interface IUserRegisterService {

    /**
     * 注册用户
     * @param userDTO
     * @return
     */
    boolean Register(UserDTO userDTO);

    /**
     * 删除用户
     * @param userDTO
     * @return
     */
    boolean DeleteUser(UserDTO userDTO);

    //用户登录方法
}
