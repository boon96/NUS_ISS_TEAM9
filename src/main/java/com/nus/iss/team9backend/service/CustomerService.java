package com.nus.iss.team9backend.service;

import com.nus.iss.team9backend.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO save(CustomerDTO customerDTO);

    CustomerDTO get(Long customerId);

    List<CustomerDTO> getAll();

    CustomerDTO update (Long customerId, CustomerDTO dto);

    void delete(Long customerId);
}
