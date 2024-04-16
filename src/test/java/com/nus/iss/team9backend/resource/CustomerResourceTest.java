package com.nus.iss.team9backend.resource;

import com.nus.iss.team9backend.dto.CustomerDTO;
import com.nus.iss.team9backend.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

class CustomerResourceTest {
    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerResource customerResource;

    @BeforeEach
    public void setup() {
        openMocks(this);
    }

    @Test
    void createCustomer_Success() {
        // Mocking the service behavior for success
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("John Doe");
        customerDTO.setEmailAddress("john@example.com");
        customerDTO.setPhoneNumber(1234567890L);

        CustomerDTO savedCustomer = new CustomerDTO();
        savedCustomer.setCustomerId(1L);
        savedCustomer.setName("John Doe");
        savedCustomer.setEmailAddress("john@example.com");
        savedCustomer.setPhoneNumber(1234567890L);

        when(customerService.save(customerDTO)).thenReturn(savedCustomer);

        // Calling the controller method
        ResponseEntity<CustomerDTO> responseEntity = customerResource.createCustomer(customerDTO);

        // Verifying the response for success
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(savedCustomer, responseEntity.getBody());

    }

    @Test
    void createCustomer_Failure() {
        // Mocking the service behavior for failure
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("John Doe");
        customerDTO.setEmailAddress("john@example.com");
//        customerDTO.setPhoneNumber(1234567890L);

        // Simulating failure by returning null from the service
        when(customerService.save(customerDTO)).thenReturn(null);

        // Calling the controller method
        ResponseEntity<CustomerDTO> responseEntity = customerResource.createCustomer(customerDTO);

        // Verifying the response for failure
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertEquals(null, responseEntity.getBody());
    }


    @Test
    void getCustomer_Success() {

        Long customerId = 1L;
        CustomerDTO savedCustomer = new CustomerDTO();
        savedCustomer.setCustomerId(1L);
        savedCustomer.setName("John Doe");
        savedCustomer.setEmailAddress("john@example.com");
        savedCustomer.setPhoneNumber(1234567890L);
        when(customerService.get(customerId)).thenReturn(savedCustomer);

        // Call the method being tested
        ResponseEntity<CustomerDTO> responseEntity = customerResource.getCustomer(customerId);

        // Verify the behavior
        verify(customerService, times(1)).get(customerId);
        assertSame(savedCustomer, responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void getCustomer_Failure() {
        // Mock the dependencies
        Long customerId = 1L;
        when(customerService.get(customerId)).thenReturn(null); // Simulating failure by returning null

//        YourController controller = new YourController(customerService);

        // Call the method being tested
        ResponseEntity<CustomerDTO> responseEntity = customerResource.getCustomer(customerId);

        // Verify the behavior
        verify(customerService, times(1)).get(customerId);
        assertNull(responseEntity.getBody());
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode()); // Assuming null indicates resource not found
    }

    @Test
    void verifyCustomer_Success() {
        // Mock the dependencies
        String emailAddress = "john@example.com";
        Long phoneNumber = 1234567890L;
        CustomerDTO customerDTO = new CustomerDTO();
        when(customerService.verifyCustomer(emailAddress, phoneNumber)).thenReturn(customerDTO);

        // Prepare the request body
        Map<String, String> loginInfo = new HashMap<>();
        loginInfo.put("emailAddress", emailAddress);
        loginInfo.put("phoneNumber", String.valueOf(phoneNumber));

        // Call the method being tested
        ResponseEntity<CustomerDTO> responseEntity = customerResource.verifyCustomer(loginInfo);

        // Verify the behavior
        verify(customerService, times(1)).verifyCustomer(emailAddress, phoneNumber);
        assertSame(customerDTO, responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void verifyCustomer_Failure() {
        String emailAddress = "john@example.com";
        Long phoneNumber = 1234567890L;

        // Simulate failure by returning null from the service
        when(customerService.verifyCustomer(emailAddress, phoneNumber)).thenReturn(null);

        // Prepare the request body
        Map<String, String> loginInfo = new HashMap<>();
        loginInfo.put("emailAddress", emailAddress);
        loginInfo.put("phoneNumber", String.valueOf(phoneNumber));

        // Call the method being tested
        ResponseEntity<CustomerDTO> responseEntity = customerResource.verifyCustomer(loginInfo);

        // Verify the behavior
        verify(customerService, times(1)).verifyCustomer(emailAddress, phoneNumber);

        // Assert that the response status code is NOT 200 OK
        assertNotEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}