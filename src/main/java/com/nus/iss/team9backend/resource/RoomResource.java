package com.nus.iss.team9backend.resource;

import com.nus.iss.team9backend.dto.CustomerDTO;
import com.nus.iss.team9backend.dto.RoomDTO;
import com.nus.iss.team9backend.dto.RoomTypeDTO;
import com.nus.iss.team9backend.dto.RoomDTO;
import com.nus.iss.team9backend.service.CustomerService;
import com.nus.iss.team9backend.service.RoomService;
import com.nus.iss.team9backend.service.RoomTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room")
public class RoomResource {
    @Autowired //need this autowired if not service wont be connect to spring boot
    private RoomService roomService;

    @Autowired
    private RoomTypeService roomTypeService;

    @PostMapping
    public ResponseEntity<RoomDTO> createRoom(@RequestBody RoomDTO roomDTO){
        RoomDTO savedRoom = roomService.save(roomDTO);
        return new ResponseEntity<>(savedRoom, HttpStatus.CREATED);

    }

    @GetMapping("{id}")
    public ResponseEntity<RoomDTO> getRoom(@PathVariable("id") Long roomId){
        RoomDTO dto = roomService.get(roomId);
        return ResponseEntity.ok(dto);
    }
    @GetMapping
    public ResponseEntity <List<RoomDTO>> getAllRoom(){
        List<RoomDTO> list = roomService.getAll();
        // RoomTypeDTO roomTypeList = roomTypeService.get(list.get(0).getRoomTypeId());
        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        list.forEach(room -> {
            RoomTypeDTO roomType = roomTypeService.get(room.getRoomTypeId());
            room.setRoomTypeId(roomType.getRoomTypeId()); // Assuming there's a setter method for roomType in RoomDTO
            room.setName(roomType.getName());
            room.setDescription(roomType.getDescription());
            room.setPrice(roomType.getPrice());
        });
        return ResponseEntity.ok(list);

    }
    @PutMapping("{id}")
    public ResponseEntity<RoomDTO> updateRoom(@PathVariable("id") Long roomId,
                                                      @RequestBody RoomDTO RoomDTO){
        RoomDTO dto = roomService.update(roomId,RoomDTO);
        return ResponseEntity.ok(dto);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRoom(@PathVariable("id") Long roomId){
        roomService.delete(roomId);
        return ResponseEntity.ok("Room deleted successfully");
    }
}
