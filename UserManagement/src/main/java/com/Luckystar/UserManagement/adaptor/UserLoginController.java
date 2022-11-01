package com.Luckystar.UserManagement.adaptor;

import com.Luckystar.UserManagement.dto.UserDTO;
import com.Luckystar.UserManagement.dto.CurrentUserDTO;
import com.Luckystar.UserManagement.exception.UserNotFoundException;
import com.Luckystar.UserManagement.ports.IUserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

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
    @ResponseBody
    public String Login(UserDTO userDTO, HttpServletRequest request) throws UserNotFoundException,Exception{
        try {
//            HttpServletRequest httpServletRequest=((ServletRequestAttributes)(RequestContextHolder.currentRequestAttributes()) ).getRequest();
            userDTO=userLoginService.Login(userDTO);
            HttpSession session=request.getSession();
//            HttpSession session=httpServletRequest.getSession();
            //将用户信息放入session
            session.setAttribute("currentUser",userDTO);
            //按照用户类型重定向
            return "Login successful";
        }catch (UserNotFoundException userNotFoundException){
            throw userNotFoundException;
        } catch (Exception e){
            throw e;
        }
    }

    /**
     * 其它service获取当前用户ID和用户名
     * @param
     * @return
     */
    @RequestMapping(value = "/getCurrentUser",method = RequestMethod.POST)
    @ResponseBody
//    public CurrentUserDTO getCurrentUser (HttpServletRequest httpServletRequest){
    public CurrentUserDTO getCurrentUser (){
        HttpServletRequest httpServletRequest=((ServletRequestAttributes)(RequestContextHolder.currentRequestAttributes()) ).getRequest();
        HttpSession session=httpServletRequest.getSession();
        UserDTO userDTO=(UserDTO) session.getAttribute("currentUser");
        return new CurrentUserDTO(userDTO.getId(),userDTO.getUsername());
    }

}
