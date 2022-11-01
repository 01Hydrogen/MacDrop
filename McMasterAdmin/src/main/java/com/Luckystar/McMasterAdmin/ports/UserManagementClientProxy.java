package com.Luckystar.McMasterAdmin.ports;

import com.Luckystar.McMasterAdmin.dto.CalcMDDDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "user-management")
public interface UserManagementClientProxy {

    @RequestMapping(value = "/user/MDDAdd",method = RequestMethod.PUT)
    public String MDDAdd (@RequestBody CalcMDDDTO calcMDDDTO);
}
