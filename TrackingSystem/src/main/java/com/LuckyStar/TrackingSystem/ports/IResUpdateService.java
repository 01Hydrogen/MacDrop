package com.LuckyStar.TrackingSystem.ports;

import com.LuckyStar.TrackingSystem.dto.OrderRejectedDTO;
import com.LuckyStar.TrackingSystem.dto.ResUpdateDTO;

public interface IResUpdateService {
    public String orderRejected(OrderRejectedDTO orderRejectedDTO);
    public String statusUpdate(ResUpdateDTO resUpdateDTO);
}
