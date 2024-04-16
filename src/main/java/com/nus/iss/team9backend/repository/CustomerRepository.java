package com.nus.iss.team9backend.repository;

import com.nus.iss.team9backend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value="SELECT * " +
            "FROM tbl_customer customer " +
            "WHERE customer.email_address = :emailAddress and " +
            "customer.phone_number = :phoneNumber",nativeQuery = true)
    Optional<Customer> findByEmailAddressAndPhoneNumber (@Param("emailAddress") String emailAddress, @Param("phoneNumber") Long phoneNumber);


}
