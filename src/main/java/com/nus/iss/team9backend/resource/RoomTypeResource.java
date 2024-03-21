package com.nus.iss.team9backend.resource;

import com.nus.iss.team9backend.dto.RoomTypeDTO;
import com.nus.iss.team9backend.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("{id}")
    public ResponseEntity<RoomTypeDTO> getRoomType(@PathVariable("id") Long roomTypeId){
        RoomTypeDTO dto = roomTypeService.get(roomTypeId);
        return ResponseEntity.ok(dto);
    }
    @GetMapping
    public ResponseEntity <List<RoomTypeDTO>> getAllRoomType(){
        List<RoomTypeDTO> list = roomTypeService.getAll();
        return ResponseEntity.ok(list);

    }
    @PutMapping("{id}")
    public ResponseEntity<RoomTypeDTO> updateRoomType(@PathVariable("id") Long roomTypeId,
                                                      @RequestBody RoomTypeDTO roomTypeDTO){
        RoomTypeDTO dto = roomTypeService.update(roomTypeId,roomTypeDTO);
        return ResponseEntity.ok(dto);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRoomType(@PathVariable("id") Long roomTypeId){
        roomTypeService.delete(roomTypeId);
        return ResponseEntity.ok("RoomType deleted successfully");
    }

}
