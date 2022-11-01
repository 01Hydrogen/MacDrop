package com.LuckyStar.TrackingSystem.ports;

import com.LuckyStar.TrackingSystem.dto.BikerUpdateDTO;

public interface ISubOrderUpdateService {
    public void statusUpdate(BikerUpdateDTO bikerUpdateDTO);
}
