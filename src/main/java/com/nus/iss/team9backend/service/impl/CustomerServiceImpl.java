package com.nus.iss.team9backend.service.impl;

import com.nus.iss.team9backend.dto.CustomerDTO;
import com.nus.iss.team9backend.entity.Customer;
import com.nus.iss.team9backend.mapper.CustomerMapper;
import com.nus.iss.team9backend.repository.CustomerRepository;
import com.nus.iss.team9backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired //need this autowired if not service wont be connect to spring boot
    private CustomerRepository customerRepository;

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {

        Customer customer = CustomerMapper.mapToCustomer(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        return CustomerMapper.mapToCustomerDto(savedCustomer);
    }
}
