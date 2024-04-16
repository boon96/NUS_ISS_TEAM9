package com.nus.iss.team9backend.repository;

import com.nus.iss.team9backend.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    @Query(value="SELECT * " +
            "FROM tbl_admin admin " +
            "WHERE admin.email_address = :emailAddress and " +
            "admin.password = :password",nativeQuery = true)
    Optional<Admin> findByEmailAddressAndPassword (@Param("emailAddress") String emailAddress, @Param("password") String password);
}
