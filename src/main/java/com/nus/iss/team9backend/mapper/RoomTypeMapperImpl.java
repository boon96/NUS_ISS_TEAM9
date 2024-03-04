package com.nus.iss.team9backend.mapper;

import com.nus.iss.team9backend.dto.RoomTypeDTO;
import com.nus.iss.team9backend.entity.RoomType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoomTypeMapperImpl implements RoomTypeMapper {

    @Override
    public RoomType toEntity(RoomTypeDTO roomTypeDTO) {
        if (roomTypeDTO == null) {
            return null;
        }
        RoomType roomType = new RoomType();
        roomType.setName(roomTypeDTO.getName());
        roomType.setDescription(roomTypeDTO.getDescription());
        roomType.setPrice(roomTypeDTO.getPrice());
        return roomType;
    }

    @Override
    public RoomTypeDTO toDto(RoomType entity) {
        if (entity == null) {
            return null;
        }
        RoomTypeDTO roomTypeDTO = new RoomTypeDTO();
        roomTypeDTO.setName(entity.getName());
        roomTypeDTO.setDescription(entity.getDescription());
        roomTypeDTO.setPrice(entity.getPrice());

        return roomTypeDTO;
    }

    @Override
    public List<RoomType> toEntity(List<RoomTypeDTO> roomTypeDTOList) {
        if (roomTypeDTOList == null) {
            return null;
        }
        List<RoomType> list = new ArrayList<RoomType>(roomTypeDTOList.size());
        for (RoomTypeDTO roomTypeDTO : roomTypeDTOList) {
            list.add(toEntity(roomTypeDTO));
        }
        return list;
    }

    @Override
    public List<RoomTypeDTO> toDto(List<RoomType> roomTypeList) {
        if (roomTypeList == null) {
            return null;
        }
        List<RoomTypeDTO> list = new ArrayList<RoomTypeDTO>(roomTypeList.size());
        for (RoomType roomType : roomTypeList) {
            list.add(toDto(roomType));
        }
        return list;
    }

    @Override
    public void partialUpdate(RoomType entity, RoomTypeDTO dto) {
        if (dto == null) {
            return;
        }
        if (dto.getName() != null) {
            entity.setName(dto.getName());
        }

        if (dto.getDescription() != null) {
            entity.setDescription(dto.getDescription());
        }

        if (dto.getPrice() != null) {
            entity.setPrice(dto.getPrice());
        }

    }
}
