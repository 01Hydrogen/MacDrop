package com.Luckystar.UserManagement.adaptor;

import com.Luckystar.UserManagement.dto.UserDTO;
import com.Luckystar.UserManagement.exception.UserNotFoundException;
import com.Luckystar.UserManagement.ports.IUserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserLoginController {

    @Autowired
    IUserLoginService userLoginService;

    /**
     * 用户登录方法
     * @param userDTO
     * @param request
     * @return
     * @throws UserNotFoundException
     * @throws Exception
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String Login(UserDTO userDTO, HttpServletRequest request) throws UserNotFoundException,Exception{
        try {
//            userDTO=userLoginService.Login(userDTO);
//            if(null==userDTO){
//                return "Invalid username or password";
//            }else{
//                HttpSession session=request.getSession();
//                session.setAttribute("currentUser",userDTO);
//                return "Login successful";
//            }
            userDTO=userLoginService.Login(userDTO);
            HttpSession session=request.getSession();
            //将用户信息放入session
            session.setAttribute("currentUser",userDTO);
            //按照用户类型重定向
            return "Login successful";
        }catch (UserNotFoundException userNotFoundException){
            throw userNotFoundException;
        } catch (Exception e){
            throw e;
//            return "匹配失败";
        }

    }

}
