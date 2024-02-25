package com.nus.iss.team9backend.mapper;

import com.nus.iss.team9backend.dto.CustomerDTO;
import com.nus.iss.team9backend.entity.Customer;

public class CustomerMapper {
    public static CustomerDTO mapToCustomerDto(Customer customer){
        return new CustomerDTO(
                customer.getCustomer_id(),
                customer.getName(),
                customer.getEmail_address(),
                customer.getPhone_number()
        );

    }

    public static Customer mapToCustomer(CustomerDTO customerDto){
        return new Customer(
                customerDto.getCustomer_id(),
                customerDto.getName(),
                customerDto.getEmail_address(),
                customerDto.getPhone_number()
        );

    }

}
