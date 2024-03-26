package com.nus.iss.team9backend.resource;

import com.nus.iss.team9backend.dto.BookingDTO;
import com.nus.iss.team9backend.dto.BookingDTO;
import com.nus.iss.team9backend.dto.CustomerDTO;
import com.nus.iss.team9backend.service.BookingService;
import com.nus.iss.team9backend.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
public class BookingResource {

    private final Logger log = LoggerFactory.getLogger(BookingResource.class);

    @Autowired //need this autowired if not service wont be connect to spring boot
    private BookingService bookingService;

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<BookingDTO> createBooking(@RequestBody BookingDTO bookingDTO){
        BookingDTO savedBooking = bookingService.save(bookingDTO);
        
        CustomerDTO customerDTO = customerService.get(bookingDTO.getCustomerId());
        savedBooking.setName(customerDTO.getName());
        savedBooking.setEmailAddress(customerDTO.getEmailAddress());
        savedBooking.setPhoneNumber(customerDTO.getPhoneNumber());
        return new ResponseEntity<>(savedBooking, HttpStatus.CREATED);

    }
    @GetMapping("{id}")
    public ResponseEntity<BookingDTO> getBooking(@PathVariable("id") Long bookingId){
        BookingDTO dto = bookingService.get(bookingId);
        CustomerDTO customerDTO = customerService.get(dto.getCustomerId());
        dto.setName(customerDTO.getName());
        dto.setEmailAddress(customerDTO.getEmailAddress());
        dto.setPhoneNumber(customerDTO.getPhoneNumber());
        return ResponseEntity.ok(dto);
    }
    @GetMapping
    public ResponseEntity <List<BookingDTO>> getAllBooking(){
        List<BookingDTO> list = bookingService.getAll();
        return ResponseEntity.ok(list);

    }
    @PutMapping("{id}")
    public ResponseEntity<BookingDTO> updateBooking(@PathVariable("id") Long bookingId,
                                                      @RequestBody BookingDTO bookingDTO){
        BookingDTO dto = bookingService.update(bookingId,bookingDTO);
        return ResponseEntity.ok(dto);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long bookingId){
        bookingService.delete(bookingId);
        return ResponseEntity.ok("Booking deleted successfully");
    }
}
