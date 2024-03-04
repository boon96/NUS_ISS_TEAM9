package com.nus.iss.team9backend.repository;

import com.nus.iss.team9backend.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository  extends JpaRepository<Room, Long> {
}
