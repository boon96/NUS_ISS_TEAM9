package com.nus.iss.team9backend.repository;

import com.nus.iss.team9backend.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
