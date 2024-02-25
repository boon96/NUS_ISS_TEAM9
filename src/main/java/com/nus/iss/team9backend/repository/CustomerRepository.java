package com.nus.iss.team9backend.repository;

import com.nus.iss.team9backend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
