package com.nus.iss.team9backend.mapper;

import com.nus.iss.team9backend.dto.RoomTypeDTO;
import com.nus.iss.team9backend.entity.RoomType;

public class RoomTypeMapper {

    public static RoomTypeDTO mapToRoomTypeDto(RoomType roomType){
        return new RoomTypeDTO(
                roomType.getRoomTypeId(),
                roomType.getName(),
                roomType.getDescription(),
                roomType.getPrice()
        );
    }

    public static RoomType mapToRoomType(RoomTypeDTO roomTypeDTO){
        return new RoomType(
                roomTypeDTO.getRoomTypeId(),
                roomTypeDTO.getName(),
                roomTypeDTO.getDescription(),
                roomTypeDTO.getPrice()
        );
    }
}
