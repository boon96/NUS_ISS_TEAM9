package com.nus.iss.team9backend.resource;

import com.nus.iss.team9backend.dto.RoomTypeDTO;
import com.nus.iss.team9backend.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roomtype")
public class RoomTypeResource {

    @Autowired
    private RoomTypeService roomTypeService;

    @PostMapping
    public ResponseEntity<RoomTypeDTO> createRoomType(@RequestBody RoomTypeDTO roomTypeDTO){
        RoomTypeDTO savedRoomType = roomTypeService.save(roomTypeDTO);
        return new ResponseEntity<>(savedRoomType, HttpStatus.CREATED);
    }

}
