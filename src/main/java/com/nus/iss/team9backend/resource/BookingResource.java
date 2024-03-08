package com.nus.iss.team9backend.resource;

import com.nus.iss.team9backend.dto.BookingDTO;
import com.nus.iss.team9backend.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/booking")
public class BookingResource {

    @Autowired //need this autowired if not service wont be connect to spring boot
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<BookingDTO> createBooking(@RequestBody BookingDTO bookingDTO){
        BookingDTO savedBooking = bookingService.save(bookingDTO);
        return new ResponseEntity<>(savedBooking, HttpStatus.CREATED);

    }
}
