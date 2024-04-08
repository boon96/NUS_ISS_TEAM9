package com.nus.iss.team9backend.resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.nus.iss.team9backend.dto.BookingDTO;
import com.nus.iss.team9backend.dto.CustomerDTO;
import com.nus.iss.team9backend.service.BookingService;
import com.nus.iss.team9backend.service.CustomerService;
import com.nus.iss.team9backend.service.RoomService;
import com.nus.iss.team9backend.resource.BookingResource;


public class BookingResourceTest {
    private final Logger log = LoggerFactory.getLogger(BookingResourceTest.class);

    @Test
    void testCreateBooking() {
        BookingService bookingService = mock(BookingService.class);
        CustomerService customerService = mock(CustomerService.class);
        RoomService roomService = mock(RoomService.class);

        // Create instance of the class to be tested
        BookingResource bookingResource = new BookingResource();
        bookingResource.setBookingService(bookingService);
        bookingResource.setCustomerService(customerService);
        bookingResource.setRoomService(roomService);

        // Create test data
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setCustomerId(1L);
        bookingDTO.setCheckInDate(null);
        bookingDTO.setCheckOutDate(null);
        // Set other properties as needed

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerId(1L);
        customerDTO.setName("John Doe");
        customerDTO.setEmailAddress("john@example.com");
        customerDTO.setPhoneNumber(Long.parseLong("123456789"));
        bookingDTO.setCustomerId(customerDTO.getCustomerId());
        bookingDTO.setName(customerDTO.getName());
        bookingDTO.setPhoneNumber(customerDTO.getPhoneNumber());

        // Mock behavior of dependencies
        when(bookingService.save(bookingDTO)).thenReturn(bookingDTO);
        when(customerService.get(bookingDTO.getCustomerId())).thenReturn(customerDTO);

        // Call the method to be tested
        ResponseEntity<BookingDTO> response = bookingResource.createBooking(bookingDTO);

        // Assert the result
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        // Add more assertions as needed
    }

    @Test
    void testDeleteCustomer() {
        BookingService bookingService = mock(BookingService.class);
        CustomerService customerService = mock(CustomerService.class);

        // Create instance of the class to be tested
        BookingResource bookingResource = new BookingResource();
        bookingResource.setBookingService(bookingService);

        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setBookId(1L);

        // Verify that the BookingService's delete method was called with the correct bookingId


        ResponseEntity<String> response = bookingResource.deleteCustomer(bookingDTO.getBookId());
        verify(bookingService).delete(bookingDTO.getBookId());

        // Assert the result
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Booking deleted successfully", response.getBody());
        
    }

    @Test
    void testGetAllBooking() {

    }

    @Test
    void testGetBooking() {
//        // Create mock objects for services
//        BookingService bookingService = mock(BookingService.class);
//        CustomerService customerService = mock(CustomerService.class);
//
//        // Create instance of the class to be tested
//        BookingResource bookingResource = new BookingResource();
//        bookingResource.setBookingService(bookingService);
//        bookingResource.setCustomerService(customerService);
//
//        // Create a sample BookingDTO with a bookingId
//        long bookingId = 1L;
//        BookingDTO bookingDTO = new BookingDTO();
//        bookingDTO.setBookId(bookingId);
//        // Set other properties as needed
//
//        // Mock behavior of bookingService.get method to return the sample BookingDTO when called with the bookingId
//        when(bookingService.get(bookingId)).thenReturn(bookingDTO);
//
//
//        // Create a sample CustomerDTO with a customerId
//        long customerId = 1L;
//        CustomerDTO customerDTO = new CustomerDTO();
//        customerDTO.setCustomerId(customerId);
//        customerDTO.setName("John Doe");
//        customerDTO.setEmailAddress("john@example.com");
//        customerDTO.setPhoneNumber(Long.parseLong("123456789"));
//
//        // Mock behavior of customerService.get method to return the sample CustomerDTO when called with the customerId
//        when(customerService.get(customerId)).thenReturn(customerDTO);
//
//        // Call the method to be tested with the bookingId
//        ResponseEntity<BookingDTO> response = bookingResource.getBooking(bookingId);
//
//        // Assert the result
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertNotNull(response.getBody());
//        assertEquals(bookingId, response.getBody().getBookId());
//        assertEquals(customerDTO.getName(), response.getBody().getName());
//        assertEquals(customerDTO.getEmailAddress(), response.getBody().getEmailAddress());
//        assertEquals(customerDTO.getPhoneNumber(), response.getBody().getPhoneNumber());
    }

    @Test
    void testUpdateBooking() {

    }
}
