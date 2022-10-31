package com.Luckystar.UserManagement.adaptor;

import com.Luckystar.UserManagement.dto.UserDTO;
import com.Luckystar.UserManagement.ports.IUserMDDConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserMDDConsumeController {

    @Autowired
    IUserMDDConsumeService userMDDConsumeService;


    /**
     * 消费MDD
     * @param userDTO
     * @return
     */
    @RequestMapping(value = "/MDDConsume",method = RequestMethod.PUT)
    public String MDDConsume(@RequestBody UserDTO userDTO){
        boolean result= userMDDConsumeService.MDDConsume(userDTO);
        if(result){
            return "Successful";
        }else {
            return "Failure";
        }
    }

    /**
     * 增加MDD
     * @param userDTO
     * @return
     */
    @RequestMapping(value = "/MMDAdd",method = RequestMethod.PUT)
    public String MDDAdd(@RequestBody UserDTO userDTO){
        boolean result= userMDDConsumeService.MDDConsume(userDTO);
        if(result){
            return "Successful";
        }else {
            return "Failure";
        }
    }
}
