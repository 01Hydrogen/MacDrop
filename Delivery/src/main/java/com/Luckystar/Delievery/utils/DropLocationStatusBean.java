package com.Luckystar.Delievery.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DropLocationStatusBean {

    public DropLocationStatusBean(){
    }

    public DropLocationStatusBean(String locationName){
        this.locationName=locationName;
        this.timeSlot=new int[]{0,0,0,0,0};
    }

    private String locationName;

    private int[] timeSlot;
}
