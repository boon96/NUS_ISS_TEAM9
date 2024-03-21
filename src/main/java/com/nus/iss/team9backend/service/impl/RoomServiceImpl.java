package com.nus.iss.team9backend.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nus.iss.team9backend.dto.RoomDTO;
import com.nus.iss.team9backend.entity.Room;
import com.nus.iss.team9backend.exception.ResourceNotFoundException;
import com.nus.iss.team9backend.mapper.RoomMapper;
import com.nus.iss.team9backend.repository.RoomRepository;
import com.nus.iss.team9backend.service.RoomService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {
    private final EntityManager entityManager;
    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;
    @Autowired
    private ObjectMapper objectMapper;

    public RoomServiceImpl(EntityManager entityManager,RoomRepository roomRepository, RoomMapper roomMapper) {
        this.entityManager=entityManager;
        this.roomRepository=roomRepository;
        this.roomMapper=roomMapper;

    }
    @Override
    public RoomDTO save(RoomDTO roomDTO) {

        Room room =roomMapper.toEntity(roomDTO);
        room = roomRepository.save(room);
        return roomMapper.toDto(room);
    }

    @Override
    public RoomDTO get(Long roomId) {
        Room room =roomRepository.findById(roomId)
                .orElseThrow(()-> new ResourceNotFoundException("Room does not exist with the given id: "+ roomId));
        return roomMapper.toDto(room);
    }

    @Override
    public List<RoomDTO> getAll() {
        List<Room> rooms = roomRepository.findAll();
        return rooms.stream().map(roomMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RoomDTO update(Long roomId, RoomDTO dto) {
        Room room = roomRepository.findById(roomId).orElseThrow(()-> new ResourceNotFoundException("Room does not exist with the given id: "+ roomId));
        room.setStatus(dto.getStatus());
        room.setLocation(dto.getLocation());

        Room updated = roomRepository.save(room);
        return roomMapper.toDto(updated);
    }

    @Override
    public void delete(Long roomId) {
        Room room = roomRepository.findById(roomId).orElseThrow(()-> new ResourceNotFoundException("Room does not exist with the given id: "+ roomId));
        roomRepository.deleteById(roomId);

    }
}
