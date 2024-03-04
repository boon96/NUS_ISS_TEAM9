package com.nus.iss.team9backend.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nus.iss.team9backend.dto.CustomerDTO;
import com.nus.iss.team9backend.entity.Customer;
import com.nus.iss.team9backend.mapper.CustomerMapper;
import com.nus.iss.team9backend.repository.CustomerRepository;
import com.nus.iss.team9backend.service.CustomerService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final EntityManager entityManager;
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    @Autowired
    private ObjectMapper objectMapper;

    public CustomerServiceImpl(EntityManager entityManager, CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.entityManager=entityManager;
        this.customerRepository=customerRepository;
        this.customerMapper=customerMapper;

    }

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {

        Customer customer =customerMapper.toEntity(customerDTO);
        customer = customerRepository.save(customer);
        return customerMapper.toDto(customer);
    }
}
