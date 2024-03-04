package com.nus.iss.team9backend.mapper;

import com.nus.iss.team9backend.dto.RoomTypeDTO;
import com.nus.iss.team9backend.entity.RoomType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomTypeMapper extends EntityMapper<RoomTypeDTO, RoomType> {
}
