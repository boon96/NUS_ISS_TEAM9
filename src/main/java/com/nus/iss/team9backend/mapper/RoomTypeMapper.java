package com.nus.iss.team9backend.mapper;

import com.nus.iss.team9backend.dto.RoomTypeDTO;
import com.nus.iss.team9backend.entity.RoomType;

public class RoomTypeMapper {

    public static RoomTypeDTO mapToRoomTypeDto(RoomType roomType){
        return new RoomTypeDTO(
                roomType.getRoom_type_id(),
                roomType.getName(),
                roomType.getDescription(),
                roomType.getPrice()
        );
    }

    public static RoomType mapToRoomType(RoomTypeDTO roomTypeDTO){
        return new RoomType(
                roomTypeDTO.getRoom_type_id(),
                roomTypeDTO.getName(),
                roomTypeDTO.getDescription(),
                roomTypeDTO.getPrice()
        );
    }
}
