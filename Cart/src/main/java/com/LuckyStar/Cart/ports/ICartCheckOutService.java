package com.LuckyStar.Cart.ports;

import com.LuckyStar.Cart.dto.CartCheckOutDTO;
import com.LuckyStar.Cart.dto.UserInfoDTO;

import javax.servlet.http.HttpServletRequest;


public interface ICartCheckOutService {
    CartCheckOutDTO cartCheckOut(UserInfoDTO userInfoDTO);
}
