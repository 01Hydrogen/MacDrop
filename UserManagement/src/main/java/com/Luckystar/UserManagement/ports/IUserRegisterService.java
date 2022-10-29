package com.Luckystar.UserManagement.ports;

import com.Luckystar.UserManagement.dto.UserDTO;
import com.Luckystar.UserManagement.exception.FailureException;

public interface IUserRegisterService {

    /**
     * 注册用户
     * @param userDTO
     * @return
     */
    boolean Register(UserDTO userDTO) throws FailureException, Exception;

    /**
     * 删除用户
     * @param userDTO
     * @return
     */
    boolean DeleteUser(UserDTO userDTO) throws Exception;

    //用户登录方法
}
