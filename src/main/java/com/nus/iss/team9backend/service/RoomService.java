package com.nus.iss.team9backend.service;

import com.nus.iss.team9backend.dto.RoomDTO;

import java.util.List;

public interface RoomService {
    RoomDTO save(RoomDTO roomDTO);
    RoomDTO get(Long roomId);

    List<RoomDTO> getAll();

    RoomDTO update (Long roomId, RoomDTO dto);

    void delete(Long roomId);
}
