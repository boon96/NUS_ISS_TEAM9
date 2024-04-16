package com.nus.iss.team9backend.resource;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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

    @Mock
    private CustomerService customerService;

    @Mock
    private BookingService bookingService;

    @Mock
    private RoomService roomService;

    @InjectMocks
    private BookingResource bookingResource;

    @BeforeEach
    public void setup() {
        openMocks(this);
    }

    private final Logger log = LoggerFactory.getLogger(BookingResourceTest.class);

    @Test
    void testCreateBooking() {
        // Create test data
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setCustomerId(1L);
        bookingDTO.setCheckInDate(null);
        bookingDTO.setCheckOutDate(null);

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
    void testCreateBookingFailure() {
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
        // Mocking behavior to simulate failure
        when(bookingService.save(bookingDTO)).thenThrow(new RuntimeException("Failed to save booking"));
        when(customerService.get(bookingDTO.getCustomerId())).thenReturn(customerDTO);

        // Call the method to be tested
        // Since the method is expected to throw an exception, it needs to be wrapped in an assertThrows block
        assertThrows(RuntimeException.class, () -> {
            bookingResource.createBooking(bookingDTO);
        });
    }

    @Test
    void testDeleteCustomer() {

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
    void testDeleteCustomerFailure() {
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setBookId(1L);

        // Mock behavior of dependencies to simulate failure (e.g., throwing an exception)
        doThrow(new RuntimeException("Failed to delete booking")).when(bookingService).delete(bookingDTO.getBookId());

        // Call the method to be tested
        ResponseEntity<String> response = bookingResource.deleteCustomer(bookingDTO.getBookId());

        // Verify that the BookingService's delete method was called with the correct bookingId
        verify(bookingService).delete(bookingDTO.getBookId());

        // Assert the result
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode()); // Assuming failure status code
        assertNotNull(response.getBody()); // Assuming there's a message in the response body indicating failure
        assertEquals("Failed to delete booking", response.getBody()); // Assert the error message
    }

    @Test
    void testGetBooking_Success() {
        Long bookingId = 1L;
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setCustomerId(2L); // Assuming customer ID associated with the booking
        CustomerDTO customerDTO = new CustomerDTO();
        when(bookingService.get(bookingId)).thenReturn(bookingDTO);
        when(customerService.get(bookingDTO.getCustomerId())).thenReturn(customerDTO);

        // Call the method being tested
        ResponseEntity<BookingDTO> responseEntity = bookingResource.getBooking(bookingId);

        // Verify the behavior
        verify(bookingService, times(1)).get(bookingId);
        verify(customerService, times(1)).get(bookingDTO.getCustomerId());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(customerDTO.getName(), responseEntity.getBody().getName());
        assertEquals(customerDTO.getEmailAddress(), responseEntity.getBody().getEmailAddress());
        assertEquals(customerDTO.getPhoneNumber(), responseEntity.getBody().getPhoneNumber());
    }

//    @Test
//    public void testGetBooking_Failure() {
//        Long bookingId = 1L;
//        BookingDTO bookingDTO = new BookingDTO();
//        bookingDTO.setCustomerId(2L); // Assuming customer ID associated with the booking
//        when(bookingService.get(null)).thenReturn(null);
//        when(customerService.get(null)).thenReturn(null); // Simulating customer not found
//
//        // Call the method being tested
//        ResponseEntity<BookingDTO> responseEntity = bookingResource.getBooking(null);
//
//        // Verify the behavior
//        verify(bookingService, times(1)).get(bookingId);
//        verify(customerService, times(1)).get(bookingDTO.getCustomerId());
//        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode()); // Failing assertion, expecting internal server error
//        assertNull(responseEntity.getBody()); // Failing assertion, expecting null body
//    }
}
