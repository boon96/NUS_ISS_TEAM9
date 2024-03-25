package com.nus.iss.team9backend.resource;

import com.nus.iss.team9backend.dto.CustomerDTO;
import com.nus.iss.team9backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

    @RestController
    @RequestMapping("/api/customer")
    public class CustomerResource {

        @Autowired //need this autowired if not service wont be connect to spring boot
        private CustomerService customerService;

        @PostMapping
        public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO){
            CustomerDTO savedCustomer = customerService.save(customerDTO);

            return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);

        }
        @GetMapping("{id}")
        public ResponseEntity<CustomerDTO> getCustomer(@PathVariable("id") Long customerId){
            CustomerDTO dto = customerService.get(customerId);
            return ResponseEntity.ok(dto);
        }
    @GetMapping
    public ResponseEntity <List<CustomerDTO>> getAllCustomer(){
        List<CustomerDTO> list = customerService.getAll();
        return ResponseEntity.ok(list);

    }
    @PutMapping("{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable("id") Long customerId,
                                                      @RequestBody CustomerDTO customerDTO){
        CustomerDTO dto = customerService.update(customerId,customerDTO);
        return ResponseEntity.ok(dto);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long customerId){
        customerService.delete(customerId);
        return ResponseEntity.ok("Customer deleted successfully");
    }

    @PostMapping("/customer-verify")
    // public ResponseEntity<CustomerDTO> verifyCustomer(@RequestParam String emailAddress, @RequestParam Long phoneNumber){
        public ResponseEntity<CustomerDTO> verifyCustomer(@RequestBody Map<String, String> loginInfo){
        // CustomerDTO dto = customerService.verifyCustomer(emailAddress,phoneNumber);
        String emailAddress = loginInfo.get("emailAddress");
        Long phoneNumber = Long.parseLong(loginInfo.get("phoneNumber"));
        CustomerDTO dto = customerService.verifyCustomer(emailAddress, phoneNumber);
        if(dto!=null){
            return ResponseEntity.ok(dto);
        }else{
            return ResponseEntity.notFound().build();
        }

    }
}
