package com.nus.iss.team9backend.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nus.iss.team9backend.dto.RoomTypeDTO;
import com.nus.iss.team9backend.entity.Customer;
import com.nus.iss.team9backend.entity.RoomType;
import com.nus.iss.team9backend.exception.ResourceNotFoundException;
import com.nus.iss.team9backend.mapper.RoomTypeMapper;
import com.nus.iss.team9backend.repository.RoomTypeRepository;
import com.nus.iss.team9backend.service.RoomTypeService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public RoomTypeDTO get(Long roomTypeId) {
        RoomType roomtype =roomTypeRepository.findById(roomTypeId)
                .orElseThrow(()-> new ResourceNotFoundException("RoomType does not exist with the given id: "+ roomTypeId));
        return roomTypeMapper.toDto(roomtype);
    }

    @Override
    public List<RoomTypeDTO> getAll() {
        List<RoomType> roomtypes = roomTypeRepository.findAll();
        return roomtypes.stream().map(roomTypeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RoomTypeDTO update(Long roomTypeId, RoomTypeDTO dto) {
        RoomType roomtype = roomTypeRepository.findById(roomTypeId).orElseThrow(()-> new ResourceNotFoundException("RoomType does not exist with the given id: "+ roomTypeId));
        roomtype.setName(dto.getName());
        roomtype.setDescription(dto.getDescription());
        roomtype.setPrice(dto.getPrice());

        RoomType updated = roomTypeRepository.save(roomtype);
        return roomTypeMapper.toDto(updated);
    }

    @Override
    public void delete(Long roomTypeId) {
        RoomType roomtype = roomTypeRepository.findById(roomTypeId).orElseThrow(()-> new ResourceNotFoundException("RoomType does not exist with the given id: "+ roomTypeId));
        roomTypeRepository.deleteById(roomTypeId);

    }


}
