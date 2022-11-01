package com.LuckyStar.TrackingSystem.dto;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UseDropLocationDTO {

    private String locationName;
    private int timeSlotIndex;

}
