package com.nus.iss.team9backend.mapper;

import com.nus.iss.team9backend.dto.RoomDTO;
import com.nus.iss.team9backend.entity.Room;
import com.nus.iss.team9backend.entity.RoomType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.nus.iss.team9backend.repository.RoomTypeRepository;

@Component
public class RoomMapperImpl implements RoomMapper {

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Override
    public Room toEntity(RoomDTO roomDTO){
        if(roomDTO==null){
            return null;
        }
        Room room = new Room();
        room.setLocation(roomDTO.getLocation());
        room.setStatus(roomDTO.getStatus());

        if(roomDTO.getRoomTypeId()!=null){
            RoomType roomType = roomTypeRepository.findById(roomDTO.getRoomTypeId()).orElse(null); // Fetch the RoomType entity by ID
            room.setRoomType(roomType);
        }

        return room;
    }
    @Override
    public RoomDTO toDto(Room entity){
        if(entity==null){
            return null;
        }
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setLocation(entity.getLocation());
        roomDTO.setStatus(entity.getStatus());

        if(entity.getRoomType() != null) {
            roomDTO.setRoomTypeId(entity.getRoomType().getRoomTypeId()); // Set the RoomTypeId from the associated RoomType entity
        }

        return roomDTO;
    }

    @Override
    public List<Room> toEntity(List<RoomDTO> roomDTOList) {
        if(roomDTOList==null){
            return null;
        }
        List<Room> list = new ArrayList<Room>(roomDTOList.size());
        for(RoomDTO roomDTO: roomDTOList){
            list.add(toEntity(roomDTO));
        }
        return list;
    }

    @Override
    public List<RoomDTO> toDto(List<Room> roomList) {
        if(roomList==null){
            return null;
        }
        List<RoomDTO> list = new ArrayList<RoomDTO>(roomList.size());
        for(Room room:roomList){
            list.add(toDto(room));
        }
        return list;
    }

    @Override
    public void partialUpdate(Room entity, RoomDTO dto) {
        if(dto==null){
            return;
        }
        if(dto.getLocation()!=null){
            dto.setLocation(dto.getLocation());
        }
        if(dto.getStatus()!=null){
            dto.setStatus(dto.getStatus());
        }
        if(dto.getRoomTypeId()!=null){
            dto.setRoomTypeId(dto.getRoomTypeId());
        }
    }
}
