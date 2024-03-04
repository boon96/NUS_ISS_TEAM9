package com.nus.iss.team9backend.mapper;

import com.nus.iss.team9backend.dto.CustomerDTO;
import com.nus.iss.team9backend.entity.Customer;

public class CustomerMapper {
    public static CustomerDTO mapToCustomerDto(Customer customer){
        return new CustomerDTO(
                customer.getCustomerId(),
                customer.getName(),
                customer.getEmailAddress(),
                customer.getPhoneNumber()
        );

    }

    public static Customer mapToCustomer(CustomerDTO customerDto){
        return new Customer(
                customerDto.getCustomerId(),
                customerDto.getName(),
                customerDto.getEmailAddress(),
                customerDto.getPhoneNumber()
        );

    }

}
