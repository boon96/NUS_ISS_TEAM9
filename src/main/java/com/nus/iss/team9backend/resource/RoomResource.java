package com.nus.iss.team9backend.resource;

import com.nus.iss.team9backend.dto.RoomDTO;
import com.nus.iss.team9backend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/room")
public class RoomResource {
    @Autowired //need this autowired if not service wont be connect to spring boot
    private RoomService roomService;

    @PostMapping
    public ResponseEntity<RoomDTO> createRoom(@RequestBody RoomDTO roomDTO){
        RoomDTO savedRoom = roomService.save(roomDTO);
        return new ResponseEntity<>(savedRoom, HttpStatus.CREATED);

    }
}
