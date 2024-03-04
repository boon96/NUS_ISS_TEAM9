package com.nus.iss.team9backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class RoomTypeDTO {
    private Long roomTypeId;
    private String name;
    private String description;
    private Double price;

}
