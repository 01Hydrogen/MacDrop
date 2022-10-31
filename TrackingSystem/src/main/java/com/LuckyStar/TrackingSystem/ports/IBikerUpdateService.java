package com.LuckyStar.TrackingSystem.ports;

import com.LuckyStar.TrackingSystem.dto.BikerUpdateDTO;

public interface IBikerUpdateService {
    public void statusUpdate(BikerUpdateDTO bikerUpdateDTO);
}
