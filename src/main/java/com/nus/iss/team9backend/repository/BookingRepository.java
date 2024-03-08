package com.nus.iss.team9backend.repository;
import com.nus.iss.team9backend.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BookingRepository extends JpaRepository<Booking, Long>{
}
