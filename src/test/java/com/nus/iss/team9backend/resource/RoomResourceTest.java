package com.nus.iss.team9backend.resource;

import com.nus.iss.team9backend.dto.RoomDTO;
import com.nus.iss.team9backend.dto.RoomTypeDTO;
import com.nus.iss.team9backend.service.CustomerService;
import com.nus.iss.team9backend.service.RoomService;
import com.nus.iss.team9backend.service.RoomTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class RoomResourceTest {

    @Mock
    private RoomService roomService;

    @Mock
    private RoomTypeService roomTypeService;

    @InjectMocks
    private RoomResource roomResource;

    @BeforeEach
    public void setup() {
        openMocks(this);
    }
    
    @Test
    void getAllRoom_Success() {

        List<RoomDTO> mockRoomList = new ArrayList<>();
        RoomDTO mockRoom1 = new RoomDTO();
        mockRoom1.setRoomId(1L);
        mockRoom1.setRoomTypeId(1L); // Assuming room type ID
        mockRoomList.add(mockRoom1);

        // Mocking room type
        RoomTypeDTO mockRoomType = new RoomTypeDTO();
        mockRoomType.setRoomTypeId(1L);
        mockRoomType.setName("Standard Room");
        mockRoomType.setDescription("A standard room description");
        mockRoomType.setPrice(100.0);

        // Mock behavior
        when(roomService.getAll()).thenReturn(mockRoomList);
        when(roomTypeService.get(1L)).thenReturn(mockRoomType);

        // Call the method being tested
        ResponseEntity<List<RoomDTO>> responseEntity = roomResource.getAllRoom();

        // Verify the behavior
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        List<RoomDTO> responseBody = responseEntity.getBody();
        assertNotNull(responseBody);
        assertEquals(1, responseBody.size());

        // Verify room details
        RoomDTO roomDTO = responseBody.get(0);
        assertEquals(mockRoom1.getRoomId(), roomDTO.getRoomId());
        assertEquals(mockRoomType.getName(), roomDTO.getName());
        assertEquals(mockRoomType.getDescription(), roomDTO.getDescription());
        assertEquals(mockRoomType.getPrice(), roomDTO.getPrice());
    }

    @Test
    void getAllRoom_Failure() {
        // Mock behavior to return an empty list
        when(roomService.getAll()).thenReturn(new ArrayList<>());

        // Call the method being tested
        ResponseEntity<List<RoomDTO>> responseEntity = roomResource.getAllRoom();

        // Verify the behavior
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode()); // Expecting 500
        assertNull(responseEntity.getBody()); // Expecting null body
    }
}