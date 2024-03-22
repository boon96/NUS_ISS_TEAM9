package com.nus.iss.team9backend.mapper;

import com.nus.iss.team9backend.dto.CustomerDTO;
import com.nus.iss.team9backend.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerMapperImpl implements CustomerMapper{

    @Override
    public Customer toEntity(CustomerDTO customerDTO){
        if(customerDTO==null){
            return null;
        }
        Customer customer = new Customer();
        customer.setCustomerId(customerDTO.getCustomerId());
        customer.setName(customerDTO.getName());
        customer.setEmailAddress(customerDTO.getEmailAddress());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());

        return customer;
    }

    @Override
    public CustomerDTO toDto(Customer entity){
        if(entity==null){
            return null;
        }
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerId(entity.getCustomerId());
        customerDTO.setName(entity.getName());
        customerDTO.setEmailAddress(entity.getEmailAddress());
        customerDTO.setPhoneNumber(entity.getPhoneNumber());

        return customerDTO;
    }

    @Override
    public List<Customer> toEntity(List<CustomerDTO> customerDTOList){
        if(customerDTOList ==null){
            return null;
        }
        List<Customer> list = new ArrayList<Customer>(customerDTOList.size());
        for(CustomerDTO customerDTO: customerDTOList){
            list.add(toEntity(customerDTO));
        }
        return list;
    }

    @Override
    public List<CustomerDTO> toDto(List<Customer> customerList){
        if(customerList ==null){
            return null;
        }
        List<CustomerDTO> list = new ArrayList<CustomerDTO>(customerList.size());
        for(Customer customer: customerList){
            list.add(toDto(customer));
        }
        return list;
    }
    @Override
    public void partialUpdate(Customer entity, CustomerDTO dto){
        if(dto==null){
            return;
        }
        if(dto.getName()!=null){
            entity.setName(dto.getName());
        }

        if(dto.getEmailAddress()!=null){
            entity.setEmailAddress(dto.getEmailAddress());
        }

        if(dto.getPhoneNumber()!=null){
            entity.setPhoneNumber(dto.getPhoneNumber());
        }

    }

}
