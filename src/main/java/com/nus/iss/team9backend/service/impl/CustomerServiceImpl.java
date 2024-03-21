package com.nus.iss.team9backend.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nus.iss.team9backend.dto.CustomerDTO;
import com.nus.iss.team9backend.entity.Customer;
import com.nus.iss.team9backend.exception.ResourceNotFoundException;
import com.nus.iss.team9backend.mapper.CustomerMapper;
import com.nus.iss.team9backend.repository.CustomerRepository;
import com.nus.iss.team9backend.service.CustomerService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public CustomerDTO get (Long customerId){
        Customer customer =customerRepository.findById(customerId)
                .orElseThrow(()-> new ResourceNotFoundException("Customer does not exist with the given id: "+ customerId));
        return customerMapper.toDto(customer);
    }

    @Override
    public List<CustomerDTO> getAll(){
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(customerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO update(Long customerId, CustomerDTO dto) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(()-> new ResourceNotFoundException("Customer does not exist with the given id: "+ customerId));

        customer.setPhoneNumber(dto.getPhoneNumber());
        customer.setEmailAddress(dto.getEmailAddress());
        customer.setName(dto.getName());

        Customer updated = customerRepository.save(customer);
        return customerMapper.toDto(updated);

    }

    @Override
    public void delete(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(()-> new ResourceNotFoundException("Customer does not exist with the given id: "+ customerId));
        customerRepository.deleteById(customerId);

    }
}
