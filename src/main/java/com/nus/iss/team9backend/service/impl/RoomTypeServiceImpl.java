package com.nus.iss.team9backend.service.impl;

import com.nus.iss.team9backend.dto.RoomTypeDTO;
import com.nus.iss.team9backend.entity.RoomType;
import com.nus.iss.team9backend.mapper.RoomTypeMapper;
import com.nus.iss.team9backend.repository.RoomTypeRepository;
import com.nus.iss.team9backend.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {

    @Autowired
    private RoomTypeRepository roomTypeRepository;


    @Override
    public RoomTypeDTO createRoomType(RoomTypeDTO roomTypeDTO) {
        RoomType roomType = RoomTypeMapper.mapToRoomType(roomTypeDTO);// takes in a DTO from an input form and converts it into an object
        RoomType saveRoomType = roomTypeRepository.save(roomType);// save into db
        return RoomTypeMapper.mapToRoomTypeDto(saveRoomType);// return as DTO to be represented as a model to be sent from or to the API client.

    }
}
