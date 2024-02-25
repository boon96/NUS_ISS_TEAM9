package com.nus.iss.team9backend.repository;

import com.nus.iss.team9backend.entity.Customer;
import com.nus.iss.team9backend.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {

}
