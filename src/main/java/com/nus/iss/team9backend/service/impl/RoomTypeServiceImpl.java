package com.nus.iss.team9backend.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nus.iss.team9backend.dto.RoomTypeDTO;
import com.nus.iss.team9backend.entity.RoomType;
import com.nus.iss.team9backend.mapper.RoomTypeMapper;
import com.nus.iss.team9backend.repository.RoomTypeRepository;
import com.nus.iss.team9backend.service.RoomTypeService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {
    private final EntityManager entityManager;
    private final RoomTypeRepository roomTypeRepository;
    private final RoomTypeMapper roomTypeMapper;
    @Autowired
    private ObjectMapper objectMapper;

    public RoomTypeServiceImpl(EntityManager entityManager,RoomTypeRepository roomTypeRepository, RoomTypeMapper roomTypeMapper) {
        this.entityManager=entityManager;
        this.roomTypeRepository=roomTypeRepository;
        this.roomTypeMapper=roomTypeMapper;

    }
    @Override
    public RoomTypeDTO save(RoomTypeDTO roomTypeDTO) {

        RoomType roomType =roomTypeMapper.toEntity(roomTypeDTO);
        roomType = roomTypeRepository.save(roomType);
        return roomTypeMapper.toDto(roomType);
    }


}
