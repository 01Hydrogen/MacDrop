package com.Luckystar.UserManagement.adaptor;

import com.Luckystar.UserManagement.dto.UserDTO;
import com.Luckystar.UserManagement.ports.IUserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/UserRegister")
public class UserRegisterController {

    @Autowired
    IUserRegisterService userRegisterService;

    /**
     * 注册账户
     * @param userDTO
     * @return
     */
    @RequestMapping(value = "/Register",method = RequestMethod.POST)
    @ResponseBody
    public String Register(@RequestBody UserDTO userDTO){
        boolean result= userRegisterService.Register(userDTO);
        if(result){
            return "Successfully Registered";
        }else {
            return "Registration Failure";
        }
    }

    /**
     * 删除账户
     * @param userDTO
     * @return
     */
    @RequestMapping(value ="/DeleteAccount",method = RequestMethod.DELETE)
    @ResponseBody
    public String DeleteUser(@RequestBody UserDTO userDTO){
        boolean result= userRegisterService.DeleteUser(userDTO);
        if(result){
            return "Account erased";
        }else {
            return "Failed to erase account";
        }
    }
}
