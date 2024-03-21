package com.nus.iss.team9backend.service;

import com.nus.iss.team9backend.dto.RoomTypeDTO;

import java.util.List;


public interface RoomTypeService {
    RoomTypeDTO save(RoomTypeDTO roomTypeDTO);

    RoomTypeDTO get(Long roomTypeId);

    List<RoomTypeDTO> getAll();

    RoomTypeDTO update (Long roomTypeId, RoomTypeDTO dto);

    void delete(Long roomTypeId);
}

