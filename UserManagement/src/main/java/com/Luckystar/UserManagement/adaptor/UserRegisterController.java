package com.Luckystar.UserManagement.adaptor;

import com.Luckystar.UserManagement.dto.UserDTO;
import com.Luckystar.UserManagement.exception.FailureException;
import com.Luckystar.UserManagement.exception.UserNotFoundException;
import com.Luckystar.UserManagement.ports.IUserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
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
    public String Register(@RequestBody UserDTO userDTO) throws FailureException,Exception {
//        boolean result= userRegisterService.Register(userDTO);
//        if(result){
//            return "Successfully Registered";
//        }else {
//            return "Registration Failure";
//        }
        try {
            userRegisterService.Register(userDTO);
            return "Successfully Registered";
        }catch (FailureException failureException){
            throw failureException;
        }catch (Exception e){
            e.printStackTrace();
            return "Unexpected exception";
        }
    }

    /**
     * 删除账户
     * @param userDTO
     * @return
     */
    @RequestMapping(value ="/DeleteAccount",method = RequestMethod.DELETE)
    @ResponseBody
    public String DeleteUser(@RequestBody UserDTO userDTO) throws UserNotFoundException,Exception{
//        boolean result= userRegisterService.DeleteUser(userDTO);
//        if(result){
//            return "Account erased";
//        }else {
//            return "Failed to erase account";
//        }
        try {
            userRegisterService.DeleteUser(userDTO);
            return "Account erased";
        }catch (UserNotFoundException userNotFoundException){
            throw userNotFoundException;
        } catch (Exception e){
            return "Unexpected exception";
        }
    }
}
